#include<stdio.h>
#include<string.h>
int main()
{
	int i,j,x,a[3015],sum,o=0;
	scanf("%d",&x);
	for(i=0;i<x;i++)//ѭ����������
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<x;i++)
	{
		sum=0;
		a[i]=-a[i];//�޸�����
		for(j=0;j<x;j++)
		{
			sum+=a[j];//�ۼ����
		}
		a[i]=-a[i];//�ָ�ԭ����
		if(sum==0)o++;
	}
	if(o)printf("%d",o);
	else
		printf("-1");
}
