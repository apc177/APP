#include<stdio.h>
#include<string.h>
int X(int a,int b)//�ж��������Ƿ���
{
	int i;
	for(i=a<b?a:b;i>1;i--)
	{
		if(a%i==0&&b%i==0)return 0;
	}
	return 1;
}
int main()
{
	int a,b,c,x,sum=0;
	end:
	while(scanf("%d",&x)!=EOF)//��������
	{
		if(x>2&&x%3!=0)//����x����ֻ���������µ��������
		{
			for(a=x;a>=1;a--)
			{
				for(b=a-1;b>=1;b--)
				{
					for(c=b-1;c>=1;c--)
					{
						if(X(a,b)==1&&X(a,c)==1&&X(b,c)==1)
						{
							sum=a*b*c;
							printf("%d\n",sum);
							goto end;//����ȥ������������
						}
					}
				}
			}
		}
		else if(x%3==0)printf("%d\n",(x-1)*(x-2)*(x-3));//������������3�ı������Ǿ�ȡ�����������1���ɱ�֤��������
		else
			printf("%d\n",x);
	}
}
