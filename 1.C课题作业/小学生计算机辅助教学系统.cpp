#include <stdio.h>
#include<time.h>
#include<stdlib.h>
int main()
{
	int a,b,c,d,x,m=0,y=0,sum;//������¼��ȷ������m,������y
	srand(time(NULL));//�ı�α������������������
	do//�������ѭ��
	{
		end:
		a=rand()%10+1;
		b=rand()%10+1;	//�������������
		c=rand()%4;//�����������
		d=rand()%4+1;//������ĿҪ�������������switchʹ��
		if(c==0)
		{
			sum=a+b;//sum������¼��ȷ���
			printf("%d+%d=?\n",a,b);
		}
		else if(c==1)
		{
			sum=a-b;
			printf("%d-%d=?\n",a,b);
		}
		else if(c==2)
		{
			sum=a*b;
			printf("%d*%d=?\n",a,b);
		}
		else if(c==3)
		{
			sum=a/b;
			printf("%d/%d=?\n",a,b);
		}
		y++;
		scanf("%d",&x);
		if(x==sum)//�ȽϽ���Ƿ���ȷ�����ж�
		{
			printf("Right!\n");
			m++;
			switch(d)//���������d��ֵ��������ظ�
			{
			case 1:{printf("Very good!\n");break;}
			case 2:{printf("Exedllent!\n");break;}
			case 3:{printf("Nice work!\n");break;}
			case 4:{printf("Keep up the good work!\n");break;}
			}
		}
		else
		{
			printf("Wrong!\n");
			switch(d)
			{
			case 1:{printf("No.Please try again.\n");break;}
			case 2:{printf("Wrong.Try once more.\n");break;}
			case 3:{printf("Dno't give up!\n");break;}
			case 4:{printf("Not correct.Keep trying.\n");break;}
			}
		}
	}while(y<10);
	printf("�÷֣�%d\n",m*10);
	printf("��ȷ�ʣ�%d%%\n",m*10);
	if(m<8)
	{
		printf("��ȷ�ʲ���75%����������\n");
		m=0;
		y=0;
		goto end;//���ﲻ����ȷ���ظ�ѭ��
	}
}	
