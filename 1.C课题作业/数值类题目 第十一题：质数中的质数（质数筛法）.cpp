#include <stdio.h>
#define N 1000000
int a[N]={0},b[N]={1,1,0};//����ɸ
int main()
{
	int i,j,x=1,n,z=1;
	for(i=2;i<N;i++)//ɸѡ���е�����
	{
		if(!b[i])
		{
			a[z]=i;
			z++;//������a�д�������
		}
		for(j=i*2;j<N;j+=i)
		{
			b[j]=1;//�������������λ1
		}
	}
	scanf("%d",&n);
	while(a[a[x]]<n){x++;}//Ѱ�ұ�n�����С������������
	printf("%d",a[a[x]]);
}
