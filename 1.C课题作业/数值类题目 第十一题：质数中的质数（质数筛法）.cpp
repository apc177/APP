#include <stdio.h>
#define N 1000000
int a[N]={0},b[N]={1,1,0};//建立筛
int main()
{
	int i,j,x=1,n,z=1;
	for(i=2;i<N;i++)//筛选所有的质数
	{
		if(!b[i])
		{
			a[z]=i;
			z++;//在数组a中储存质数
		}
		for(j=i*2;j<N;j+=i)
		{
			b[j]=1;//将非质数数组记位1
		}
	}
	scanf("%d",&n);
	while(a[a[x]]<n){x++;}//寻找比n大的最小的质数的质数
	printf("%d",a[a[x]]);
}
