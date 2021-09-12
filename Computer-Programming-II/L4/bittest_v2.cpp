

	#include <iostream>
	#include <iomanip>
	#include <bitset>
	using namespace std ;

int main(){
    int items,i;
    bitset<4>mybitset;
    while(mybitset.to_string()!="1111"){
        i=rand()%4;
        switch (i) {
            case 0:mybitset[0]=1;break;
            case 1:mybitset[1]=1;break;
            case 2:mybitset[2]=1;break;
            case 3:mybitset[3]=1;break;
        }
        cout<<i<<endl;
        items++;
    }
    cout << items;
}