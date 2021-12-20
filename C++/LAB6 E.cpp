//hash+二分
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <string>
#include <iostream>
#include <cmath>
#include <map>
#include <queue>
using namespace std;

#define ls(rt) rt*2
#define rs(rt) rt*2+1
#define ll long long
#define ull unsigned long long
#define rep(i,s,e) for(int i=s;i<e;i++)
#define repe(i,s,e) for(int i=s;i<=e;i++)
#define CL(a,b) memset(a,b,sizeof(a))
#define IN(s) freopen(s,"r",stdin)
#define OUT(s) freopen(s,"w",stdin)
const ull B = 1e8+7;    /*according to the book*/
const int MAXN = 100000+100;
char a[MAXN],b[MAXN],tmp[MAXN];
int n,m;
ull ah[MAXN],base[MAXN];

int C(int len)
{
    int pos=m-len+1;
    ull bh=0,tmp=0;
    for(int i=0;i<len;i++)
        tmp=tmp*B+a[i];
    ah[0]=tmp;
    for(int i=0;i+len<=n;i++)//
    ah[i+1]=ah[i]*B+a[i+len]-a[i]*base[len];
    sort(ah,ah+n-len+1);
    for(int i=0;i<len;i++)
        bh=bh*B+b[i];
    for(int k=0;k<pos;k++)
    {
        if(binary_search(ah,ah+n-len+1,bh))
        {
            return 1;
        }
        bh=bh*B+b[k+len]-b[k]*base[len];
    }
    return 0;
}

int solve()
{
    n=strlen(a),m=strlen(b);// a--long b-short
    if(n<m)
    {
        swap(n,m);
        strcpy(tmp,a);
        strcpy(a,b);
        strcpy(b,tmp);
    }
    int d=0,up=m+1,mid;
    while(up>d+1)
    {
        mid=(d+up)/2;
        if(C(mid))d=mid;
        else up=mid;
    }
    return d;
}

int main()
{
    //IN("poj2774.txt");
    base[0]=1;
    for(int i=1;i<MAXN;i++)
        base[i]=base[i-1]*B;
    while(~scanf("%s%s",a,b))
    {
        printf("%d\n",solve());
    }
    return 0;
}