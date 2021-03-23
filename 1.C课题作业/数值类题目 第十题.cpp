#include<stdio.h>
#include<string.h>
int main()
{
	int i,j,x,o=0;
	scanf("%d",&x);
	for(i=10000;i<999999;i++)
	{
		if(i>10000&&i<99999)//考虑5位回文数
		{
			int a,b,c,d,e;
			a=i/10000;
			b=(i%10000)/1000;
			c=(i%1000)/100;
			d=(i%100)/10;
			e=i%10;
			if(a==e&&b==d&&a+b+c+d+e==x)
			{
				printf("%d\n",i);o++;
			}

		}
		else//考虑6位回文数
		{
			int a,b,c,d,e,f;
			a=i/100000;
			b=(i%100000)/10000;
			c=(i%10000)/1000;
			d=(i%1000)/100;
			e=(i%100)/10;
			f=i%10;
			if(a==f&&b==e&&c==d&&a+b+c+d+e+f==x)
			{
				printf("%d\n",i);o++;
			}
		}
	}
	if(o==0)printf("-1");//不存在的情况
}
