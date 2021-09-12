#include <iostream>

using namespace std;

int main()
{
    int grade;
    
    cout << "What grade did you make? ";
    cin >> grade;
    if(grade < 0){
        cout << "See you next term: " << grade << "!" << endl;
    }
    else if(grade < 60){
        cout << "We need to talk: F\n";
    }
    else if(grade < 70){
        cout << "Not so good: D\n";
    }
    else if(grade < 80){
        cout << "Not bad: C\n";
    }
    else if(grade < 90){
        cout << "Good job: B\n";
    }
    else if(grade < 100){
        cout << "Very good: A\n";
    }
    else if(grade == 100){
        cout << "Congratulations, you got a perfect score: A+\n";
    }
    else if(grade > 100){
        cout << "How do you get this: " << grade << " ?!" << endl;
    }
    return 0;
}
