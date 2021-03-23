#include<stdio.h>
#include<string.h>
int main()
{
	int i,j,x,a[3015],sum,o=0;
	scanf("%d",&x);
	for(i=0;i<x;i++)//循环输入数组
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<x;i++)
	{
		sum=0;
		a[i]=-a[i];//修改正负
		for(j=0;j<x;j++)
		{
			sum+=a[j];//累加求和
		}
		a[i]=-a[i];//恢复原数据
		if(sum==0)o++;
	}
	if(o)printf("%d",o);
	else
		printf("-1");
}
