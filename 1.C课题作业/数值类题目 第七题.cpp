#include<stdio.h>
#include<string.h>
int main()
{
	int i,x;
	char a[100];
	scanf("%d",&x);
	getchar();
	for(i=0;i<x;i++)
	{
		gets(a);
		int o=strlen(a);
		if((a[o-1]-'0')%2)a[o-1]-=1;//ÆæÊý¼õ1
		puts(a);
	}
}
