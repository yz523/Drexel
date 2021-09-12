/**
   @file Exercise2NumericExample.cpp
   @author Yiyun Zhang
   @date Jan.16.2015
 */

#include <iostream>

using namespace std;

   const long int YEAR_ONE = 10000000000.00;
   const double YEAR_TWO = 3.00;
   const long int YEAR_THREE = -10000000000.00;
   const double YEAR_FOUR = 5.00;

int main(void)
{

   double average = YEAR_ONE + YEAR_TWO;

/**
   @define float variable average
   @add the sum of year 1 and 2 to the average
*/

	average += YEAR_THREE + YEAR_FOUR;
    
/** 
   @add the sum of year 3 and 4 to average
*/
	average = average/4;
    
/**
   @calcuate the average by dividing 4
*/
	cout << "1998 earnings were: $" << YEAR_ONE << endl;
	cout << "1999 earings were: $" <<  YEAR_TWO << endl;
	cout << "2000 earnings were: $" << YEAR_THREE << endl;
	cout << "2001 earnings were: $" << YEAR_FOUR << endl;
	cout << "Average earnings was: $" <<average << endl;
/**
   @print out the value
*/
    long double x ;
    
    
    cout << sizeof(x) << endl ;

   return 0;
}


