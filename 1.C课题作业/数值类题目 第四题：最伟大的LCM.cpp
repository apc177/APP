#include<stdio.h>
#include<string.h>
int X(int a,int b)//判断两个数是否互质
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
	while(scanf("%d",&x)!=EOF)//多组输入
	{
		if(x>2&&x%3!=0)//考虑x内数只有三个以下的特殊情况
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
							goto end;//跳出去继续输入运算
						}
					}
				}
			}
		}
		else if(x%3==0)printf("%d\n",(x-1)*(x-2)*(x-3));//考虑输入数是3的倍数，那就取最大三个数减1即可保证三三互质
		else
			printf("%d\n",x);
	}
}
