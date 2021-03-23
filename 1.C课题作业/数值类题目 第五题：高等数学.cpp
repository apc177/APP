#include<stdio.h>
#include<string.h>
int main()
{
	int i;
	double sum=0;
	for(i=1;i<=100;i++)//一直加就完事了，循环累加
	{
		sum+=i;
	}
	for(i=1;i<=50;i++)
	{
		sum+=i*i;
	}
	for(i=1;i<=10;i++)
	{
		sum+=(double)1/i;
	}
	printf("%.4lf\n",sum);
}
