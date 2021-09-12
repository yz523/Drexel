#include <iostream>
#include <complex>
#include <vector>
#include <cstdlib>

#define COMPLEX_i  complex<double>(0,1)
#define PI 3.141

using namespace std;

/* Return true if n is prime, else return false */
bool isPrime(int n)
{
	int limit = (int)sqrt(n);
	if(n < 2)
		return false;
	if(n == 2)
		return true;
	for(int i=2; i <= limit; i++)
	{
		if(n % i == 0)
			return false;
	}
	return true;
}

/* get a prime divisor of n if there exist, else return 0 */
int PrimeDivisor(int n)
{
	for(int i=2; i <= n/2; i++)
	{
		if(isPrime(i) && n % i == 0)
			return i;
	}
	return 0;
}

/* factorize n so that  n = r1r2 */
void Factorize(int n, int& r1, int& r2)
{
	r1 = PrimeDivisor(n);
	if(r1 != 0)
	{
		r2 = n/r1;
	}
	else
	{
		for(r1 = n/2; r1 <= n/2; r1++)
		{
			if(n % r1 == 0)
			{
				r2 = n/r1;
				break;
			}
		}

	}
}

/* display an array of complex numbers */
void DisplayComplexArray(string arrayName, vector<complex<double> > x)
{
	int n = x.size();
	for(int i=0; i < n; i++)
	{
		cout << arrayName << "[" << i << "] = " << x[i] << endl;
	}
}

/* create and return a sample array of n complex numbers */
vector<complex<double> > CreateComplexArray(int n)
{
	vector<complex<double> >* x = new vector<complex<double> >();
	for(int i=0; i < n; i++)
	{
		complex<double> c(i,i);
		x->push_back(c);
	}

	return *x;
}

/* compute and return the FFT of input complex array x of size n */
vector<complex<double> > FFT_dyadic(int n, vector<complex<double> > x)
{
	if(n == 1)
	{
		vector<complex<double> >* fftOutput = new vector<complex<double> >();
		fftOutput->push_back(x[0]);
		return *fftOutput;
	}
	else
	{
		// declare even and odd array 
		vector<complex<double> > evenarray;
		vector<complex<double> > oddarray;

		// fill the evenarray and oddarray
		for(int i=0; i <= n-2; i += 2)
		{
			evenarray.push_back(x[i]);
			oddarray.push_back(x[i+1]);
		}

		// recursive call
		vector<complex<double> > u = FFT_dyadic(n/2, evenarray);
		vector<complex<double> > v = FFT_dyadic(n/2, oddarray);

		// output FFT
		vector<complex<double> >* fftOutput = new vector<complex<double> >(n);

		for(int j=0; j < n; j++)
		{
			complex<double> power = (2*PI*j*COMPLEX_i)/(double)n;
			complex<double> t = exp(power);
			(*fftOutput)[j] = u[j % n/2] + t*v[j %  n/2];
		}

		return *fftOutput;
	}
}

/* compute and return the FFT of input complex array x of any size n */
vector<complex<double> > FFT_any(int n, vector<complex<double> > x)
{
	if(isPrime(n))
	{
		vector<complex<double> >* fftOutput = new vector<complex<double> >(n);
		for(int j=0; j < n; j++)
		{
			complex<double> sum(0,0);
			
			for(int k=0; k < n; k++)
			{
				complex<double> constant = exp(((2*PI)/(double)n)*COMPLEX_i);
				complex<double> tmp = pow(constant, j*k);
				sum += x[k]*tmp;
			}
			(*fftOutput)[j] = sum;
		}
		return *fftOutput;
	}
	else
	{
		vector<complex<double> >* fftOutput = new vector<complex<double> >(n);

		// factorize n to r1 and r2
		int r1, r2;
		char arrName[10];
		Factorize(n, r1, r2);

		vector<complex<double> >* a = new vector<complex<double> >[r1]; 

		for(int k=0; k < r1; k++)
		{
			vector<complex<double> >* tmp = new vector<complex<double> > ();
			for(int l=0; l < r2; l++)
			{
				tmp->push_back(x[k + l*r1]);
			}
			a[k] = FFT_any(r2, *tmp);
		}
		for(int j=0; j < n; j++)
		{
			complex<double> sum(0,0);
			
			for(int k=0; k < r1; k++)
			{
				complex<double> constant = exp(((2*PI)/(double)n)*COMPLEX_i);
				complex<double> tmp2 = a[k][j % r2]*pow(constant, j*k);
				sum += tmp2;
			}
			(*fftOutput)[j] = sum;
		}
		return *fftOutput;
	}
}



int main(int argc, char *argv[])
{

	// let n = 8 for FFT dyadic 
	int n = 8;

	// create the input complex array to FFT
	vector<complex<double> > x = CreateComplexArray(n);
	
	// ---- run FFT with dyadic ie n = power of 2
	cout << endl << "Testing FFT(dyadic) with n = " << n << endl;

	// display input complex array
	cout << endl << "Input complex array(x):" << endl;
	for(int i=0; i < x.size(); i++)
	{
		cout << "x[" << i << "] = " << x[i] << endl;
	}

	// create the FFT output complex array
	vector<complex<double> > fftOutput = FFT_dyadic(n, x);

	// display FFT output
	cout << endl << "Output complex array(fft):" << endl;
	for(int i=0; i < x.size(); i++)
	{
		cout << "fft[" << i << "] = " << fftOutput[i] << endl;
	}

	// ------- run FFT with any size ---------

	n = 10;

	cout << endl << endl << "Testing FFT(any size) with n = " << n << endl;

	// display input complex array
	cout << endl << "Input complex array(x):" << endl;
	for(int i=0; i < x.size(); i++)
	{
		cout << "x[" << i << "] = " << x[i] << endl;
	}

	// create the FFT output complex array
	fftOutput = FFT_dyadic(n, x);

	// display FFT output
	cout << endl << "Output complex array(fft):" << endl;
	for(int i=0; i < x.size(); i++)
	{
		cout << "fft[" << i << "] = " << fftOutput[i] << endl;
	}


	return 0;
}