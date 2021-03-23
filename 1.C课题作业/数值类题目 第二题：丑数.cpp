#include<stdio.h>
#include<string.h>
int A(int  number)//判断是否为丑数
{
    while (number %2==0)
        number/=2;
    while (number %3==0)
        number/=3;
    while (number %5==0)
        number/=5;
	while (number %7==0)
        number/=7;
    return (number==1)?1:0;
}
int main()
{
	int n,i,sum=0;
	while(scanf("%d",&n)!=EOF&&n)//多组输入
	{
		for(i=1;;i++)//遍历整数
		{
			int m;
			m=A(i);
			if(m==0)continue;
			else
				sum++;//直到计数器和n相等为止
			if(sum==n)
			{
				sum=0;
				if(n%10==1&&n/10!=1){printf("The %dst humble number is %d.\n",n,i);break;}
				if(n%10==2&&n/10!=1){printf("The %dnd humble number is %d.\n",n,i);break;}
				if(n%10==3&&n/10!=1){printf("The %drd humble number is %d.\n",n,i);break;}
				else {printf("The %dth humble number is %d.\n",n,i);break;}
			}
		}
	}
}
