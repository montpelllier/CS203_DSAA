#include <iostream>
#include <cmath>
using namespace std;

int main (){
    int t;
    long long n;
    cin >> t;
    while (t-->0){
        cin >> n;
        cout << (long long ) ceil((log(n+1)/log(2))) << endl;
    }
}