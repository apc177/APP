#include<stdio.h>
#include<string.h>
int main()
{
	int i;
	double sum=0;
	for(i=1;i<=100;i++)//һֱ�Ӿ������ˣ�ѭ���ۼ�
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
