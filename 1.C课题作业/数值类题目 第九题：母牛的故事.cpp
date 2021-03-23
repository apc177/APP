#include<stdio.h>
#include<string.h>
int G(int n)
{
    if(n<=4)
		return n;
    else
        return G(n-3)+G(n-1) ;
}
int main()
{
	int n,i,sum=0;
	while(scanf("%d",&n)!=EOF&&n)//¶à×éÊäÈë
	{
		  printf("%d\n",G(n));
	}
}
