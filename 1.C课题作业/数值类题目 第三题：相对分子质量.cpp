#include<stdio.h>
#include<string.h>
int main()
{
	char a[100]={0};
	int x,l,i,j,sum=0,o=0;//o��¼��һ�μӵ���
	scanf("%d",&x);
	for(i=0;i<x;i++)//ѭ��x��
	{
		scanf("%s",&a);
		l=strlen(a);//l��¼�ַ������鳤��
		for(j=0;j<l;j++)
		{
			if(a[j]=='H'){sum++;o=1;}
			if(a[j]=='C'){sum+=12;o=12;}
			if(a[j]=='N'){sum+=14;o=14;}
			if(a[j]=='O'){sum+=16;o=16;}
			if(a[j]=='F'){sum+=19;o=19;}
			if(a[j]=='P'){sum+=31;o=31;}
			if(a[j]=='S'){sum+=32;o=32;}
			if(a[j]=='K'){sum+=39;o=39;}
			if(a[j]<'9'&&a[j]>'0')//�������־������ټ���ǰһ��ԭ��������a[j]-1��
				sum+=(a[j]-'1')*o;
		}printf("%d",sum);sum=0;printf("\n");
	}
}
