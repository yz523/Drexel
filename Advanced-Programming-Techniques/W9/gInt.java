public class gInt {
	int a = 0;
	int b = 0;

	//c'tor
	public gInt(int r){
		a = r;
	}

	//c'tor
	public gInt(int r, int i){
		a = r;
		b = i;
	}

	//real part
	public int real(){
		return a;
	}

	//imaginary part
	public int imag(){
		return b;
	}

	//return a new gIng, the sum of this and rhs
	gInt add(gInt rhs){
		gInt sum = new gInt((a + rhs.real()), (b + rhs.imag()));
		return sum;
	}

	//return a new gInt, the product of this and rhs
	gInt multiply(gInt rhs){
		gInt product = new gInt(((a*rhs.real())-(b*rhs.imag())), ((a*rhs.imag())+(b*rhs.real())));
		return product;
	}

	//return the L2-norm of the integer
	float norm(){
		float r = (float)Math.sqrt((a * a) + (b * b));
		return r;
	}
}
