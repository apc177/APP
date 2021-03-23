#include<stdio.h>
#include<string.h>
int main()
{
	int i,x=0,y=0,z=0,a[10],b[10];
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<10;i++)
	{
		scanf("%d",&b[i]);
	}
	for(i=0;i<10;i++)
	{
		if(a[i]>b[i])x++;
		else if(a[i]<b[i])y++;
		else z++;
	}
	printf("%d %d %d\n",x,z,y);
	if(x>y)printf("a>b");
	if(x<y)printf("a<b");
	if(x==y)printf("a=b");
}
