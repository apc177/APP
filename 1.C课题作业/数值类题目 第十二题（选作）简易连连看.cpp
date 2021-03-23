#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
#define ms(x, n) memset(x,n,sizeof(x));
typedef  long long LL;
const int inf = 1<<30;
const LL maxn = 35;
int N, pre[maxn], in[maxn], post[maxn];
struct node{
    int v, l, r;
}T[maxn];
int no = 0;
int create(int postL, int postR, int inL, int inR){
    if(postL > postR)
        return -1;
    int last = no;           //±£´æ¸¸½Úµã
    T[no++].v = post[postR];
    int k;
    for(k = inL; k <= inR; k++)
        if(in[k] == post[postR])
            break;
    int numLeft = k-inL;
    T[last].l = create(postL, postL+numLeft-1, inL, k-1);
    T[last].r = create(postL+numLeft, postR-1, k+1, inR);
    return last;
}
int main()
{
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> post[i];
    for(int i = 0; i < N; i++)
        cin >> in[i];
    ms(T, -1);
	create(0, N-1, 0, N-1);
	for(int i=0;i<N;i++)
	{
		if(T[i].v!=-1)
		printf("%d",T[i].v);
	}
}
