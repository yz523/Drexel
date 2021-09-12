#include <iostream>
using namespace std;
int main()
{
    int grade;
    cout << "What grade did you make? ";
    cin >> grade;
    
    switch(grade){
        case 0 ... 60:
            cout << "We need to talk: F\n";
            break;
        case 61 ... 70:
            cout << "Not so good: D\n";
            break;
        case 71 ... 80:
            cout << "Not bad: C\n";
            break;
        case 81 ... 90:
            cout << "Good job: B\n";
            break;
        case 91 ... 99:
            cout << "Very good: A\n";
            break;
        case 100:
            cout << "Congratulations, you got a perfect score: A+\n";
            break;
        default:
            cout << "Rejected letter grade is given!" << endl;
            break;
    }
    return 0;
}