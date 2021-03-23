#include<stdio.h>
#include<string.h>
int main()
{
	int x,i,j,o=0,m=0,z;
	scanf("%d",&x);
	getchar();//清除缓存区
	for(i=0;i<x;i++)
	{
	char a[3015],b[50][20];//定义局部变量,方便数组归零
		gets(a);
		for(j=strlen(a)-1;j>=0;j--)
		{
			if(a[j]==' ')//遇到空格符号数组b换行从b[m+1][0]开始读入
			{
				b[m][o]='\0';
				o=0;
				m++;
				continue;
			}
			b[m][o]=a[j];
			o++;
		}
		b[m][o]='\0';//字符串末尾加‘0’，输出停止标志
		for(z=m;z>0;z--)//倒着输出
		{
			printf("%s ",b[z]);
		}
		printf("%s\n",b[0]);
		m=0;
		o=0;
	}
}
