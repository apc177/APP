#include<stdio.h>
#include<string.h>
int main()
{
	int x,i,j,o=0,m=0,z;
	scanf("%d",&x);
	getchar();//���������
	for(i=0;i<x;i++)
	{
	char a[3015],b[50][20];//����ֲ�����,�����������
		gets(a);
		for(j=strlen(a)-1;j>=0;j--)
		{
			if(a[j]==' ')//�����ո��������b���д�b[m+1][0]��ʼ����
			{
				b[m][o]='\0';
				o=0;
				m++;
				continue;
			}
			b[m][o]=a[j];
			o++;
		}
		b[m][o]='\0';//�ַ���ĩβ�ӡ�0�������ֹͣ��־
		for(z=m;z>0;z--)//�������
		{
			printf("%s ",b[z]);
		}
		printf("%s\n",b[0]);
		m=0;
		o=0;
	}
}
