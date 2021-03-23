#include <stdio.h>
#include<time.h>
#include<stdlib.h>
int main()
{
	int a,b,c,d,x,m=0,y=0,sum;//用来记录正确次数的m,计数器y
	srand(time(NULL));//改变伪随机数，设随机数种子
	do//输入继续循环
	{
		end:
		a=rand()%10+1;
		b=rand()%10+1;	//设置两个随机数
		c=rand()%4;//用来随机符号
		d=rand()%4+1;//设置题目要求的随机数，配合switch使用
		if(c==0)
		{
			sum=a+b;//sum用来记录正确结果
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
		if(x==sum)//比较结果是否正确给出判断
		{
			printf("Right!\n");
			m++;
			switch(d)//根据随机数d的值给出随机回复
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
	printf("得分：%d\n",m*10);
	printf("正确率：%d%%\n",m*10);
	if(m<8)
	{
		printf("正确率不到75%，需重做！\n");
		m=0;
		y=0;
		goto end;//若达不到正确率重复循环
	}
}	
