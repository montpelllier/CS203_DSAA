#include <iostream>
#include <cmath>
using namespace std;

int main (){
    int t, n, k;
    cin >> t;
    while (t-->0){
        cin >> n >> k;
        int h = log(n)/log(k);//已经填满的层数
        int power = pow(k,h);
        int bottom = n-(power-1)/(k-1);//最后一层节点数
        int ans = bottom+power/k-bottom/k;//最后一层节点数+倒数第二层leaf node数
        if(bottom%k>0) ans--;//若最后一层按k分组有余，节点数-1
        cout << ans << endl;
    }
}
