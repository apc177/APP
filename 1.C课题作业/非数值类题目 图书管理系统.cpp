#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<algorithm>
#include<windows.h>
int x;//ִ�в���
int sum=0;/*��¼���漸���鼮��Ϣ��*/
char SMM[10];/*��¼��ǰѧ������*/
struct book
{
	char bookname[20];//����
	char writer[20];//������
	int M;//�����
	char print[20];//���浥λ
	int time;//����ʱ��
	float price;//�۸�
	char student[10];//�ĸ�ѧ�����
	int shijian;//����ʱ��
}BOOK[1001];
struct stt 
{
	char name[20];
	struct stt *next;
};
struct stt *head=NULL;
void land();//��ҳ��
void menu1();//����Ա��½�˵�
void menu2();//ѧ����½�˵�
void manage();//����Աϵͳ
void enter();//ͼ����Ϣ¼��
void browse();//ͼ����Ϣ���
void view();//ͼ���ѯ
void amend();//ͼ����Ϣ�޸�ɾ��
void student();//ѧ��ϵͳ
void borrow();//ѧ������
void bring();//ѧ���黹
void search();//ѧ����ѯ
void P1();
void P2();
void P3();//����
void J1();
void J2();
void J3();//����
void M1();//ɾ��
void M2();//�޸�
void GXGMM();//����Ա�޸�����
int c3(book a,book b)
{
	return a.price<b.price;
}
int c2(book a,book b)
{
	return strcmp(a.writer,b.writer)<0;
}
int c1(book a,book b)
{
	return strcmp(a.bookname,b.bookname)<0;
}
int main()
{	
	head = (struct stt *)malloc(sizeof(struct stt ));
	head->next=NULL;
	FILE *pp=fopen("apc2.txt","r");
	char x[20];
	struct stt *tpp=head;
	struct stt *tp=head->next;
	if(pp!=NULL)
	while(fscanf(pp,"%s ",x)!=EOF)
	{
	tp = (struct stt *)malloc(sizeof(struct stt ));
	strcpy(tp->name,x);
	tpp->next=tp;
	tpp=tpp->next;
	}
	fclose(pp);
	MessageBoxA(0,"��ӭʹ�ã�","ͼ�����ϵͳ",0);
	int i=0;
	FILE*fp=fopen("apc.txt","r");
	char a[20];
	char b[20];
	int c;
	char d[20];
	int e;
	float f;
	char g[10];
	int h;
	if(fp!=NULL)
	while(fscanf(fp,"%s %s %d %s %d %f %s %d ",a,b,&c,d,&e,&f,g,&h)!=EOF)
	{
		strcpy(BOOK[i].bookname,a);
		strcpy(BOOK[i].writer,b);
		strcpy(BOOK[i].print,d);
		strcpy(BOOK[i].student,g);
		BOOK[i].M=c;
		BOOK[i].time=e;
		BOOK[i].price=f;
		BOOK[i].shijian=h;
		i++;
		memset(a,0,sizeof(a));
		memset(b,0,sizeof(b));
		memset(d,0,sizeof(d));
		memset(g,0,sizeof(g));
	}
	sum=i;
	land();
}
void land()//������
{
	system("cls");
	system("color 06");
	printf("*************************��ӭʹ��ͼ�����ϵͳ*************************\n");
	printf("��������Ŀǰ���ִ����ز�����\n");
	printf("����Ա[1]                ѧ��[2]                �˳�ϵͳ[0]\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:printf("ϵͳ���˳���ллʹ��\n");exit(0);break;
		case 1: menu1();break;
		case 2: menu2();break;
		default :exit(0);break;
	}
}
void menu1()//����Ա��½
{
	int z;
	system("cls");
	system("color 06");
	printf("----------------------------------------------------------------------\n");
	char MM[20],GMM[20];
	FILE*fp=fopen("apc1.txt","r");
	if(fp==NULL)strcpy(MM,"1772149632");
	else
		fscanf(fp,"%s",MM);
	printf("���������Ա���룺\n");
	scanf("%s",GMM);
	if(strcmp(MM,GMM)==0)
	{
		printf("��ϲ����½�ɹ���\n");
		printf("----------------------------------------------------------------------\n");
		printf("��������Ŀǰ���ִ����ز�����\n\n");
		printf("[0]����ϵͳ\n[1]�޸�����\n");
		scanf("%d",&z);
		switch(z)
		{
		case 0:manage();break;
		case 1:GXGMM();break;
		}
	}
	else
	{
		printf("������󣬷��ز˵�\n");
		system("pause");
		land();
	}
}
void menu2()//ѧ����½
{
	FILE *fp=fopen("apc2.txt","w+");
	int flag=0;
	char x[20];
	struct stt *head2=head;
	struct stt *head1=head->next;
	struct stt *tpp=head;
	struct stt *tp=head->next;
	system("cls");
	system("color 06");
	printf("----------------------------------------------------------------------\n");
	printf("������������֣�\n");
	scanf("%s",SMM);
	while(head1!=NULL)
	{
		if(strcmp(head1->name,SMM)==0)
		{
			flag=1;
			break;
			fflush(stdin);
		}
		head1=head1->next;
		head2=head2->next;
	}
	if(flag)printf("ͬѧ��ϲ���½�ɹ�����������Զ�Ϊ����תѧ��ϵͳҳ�棡\n");
	else 
	{
		printf("��ͬѧ���\n");
		head1 = (struct stt *)malloc(sizeof(struct stt ));
		head1->next=NULL;
		strcpy(head1->name,SMM);
		head2->next=head1;
		struct stt *head2=head->next;
		while(head2!=NULL)
		{
			fprintf(fp,"%s ",head2->name);
			head2=head2->next;
		}
	}
	fclose(fp);
	system("pause");
	student();
}	
void manage()//����Ա����ϵͳ
{
	system("cls");
	system("color 06");
	printf("----------------------------------------------------------------------\n");
    printf("��������Ŀǰ���ִ����ز�����\n\n");
    printf("[1]ͼ����Ϣ¼��\n[2]ͼ����Ϣ���\n[3]ͼ���ѯ\n[4]ͼ����Ϣ�޸�\n");
    printf("[0]������ҳ\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:land();break;
		case 1:enter();break;
		case 2:browse();break;
		case 3:view();break;
		case 4:amend();break;
		default :exit(0);break;
	}
}
void  student()//ѧ������ϵͳ
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("��������Ŀǰ���ִ����ز�����\n\n");
    printf("[1] ����ͼ��\n[2] �黹ͼ��\n[3] ��ѯ\n");
    printf("[0] ������ҳ\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:land();break;
		case 1:borrow();break;
		case 2:bring();break;
		case 3:search();break;
		default :exit(0);break;
	}
}
void enter()//ͼ����Ϣ¼��
{
	system("cls");
	int k,i;
	printf("¼�뼸�����ͼ����Ϣ��\n");
	scanf("%d",&k);
	getchar();//���������
	FILE*fp;
	fp=fopen("apc.txt","a+");
	for(i=sum;i<sum+k;i++)
	{
		printf("�����鼮���ƣ�\n");
		scanf("%s",BOOK[i].bookname);
		printf("������������\n");
		scanf("%s",BOOK[i].writer);
		printf("�������ţ�\n");
		scanf("%d",&BOOK[i].M);
		printf("������浥λ��\n");
		scanf("%s",BOOK[i].print);
		printf("�������ʱ�䣺\n");
		scanf("%d",&BOOK[i].time);
		printf("����۸�\n");
		scanf("%f",&BOOK[i].price);
		printf("�����ĸ�ѧ����ģ�\n");
		scanf("%s",BOOK[i].student);
		BOOK[i].shijian=0;
		fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		printf("---------------------------------------------------------------------\n");
		printf("\n");
	}
	sum+=k;
	fclose(fp);
	printf("¼����ϣ������������\n");
	system("pause");
	manage();
}
void browse()//ͼ����Ϣ���
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("�����㵽����զ���������\n\n");
    printf("[1]���������\n[2]���������\n[3]���۸����\n");
    printf("[0]����\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:manage();break;
		case 1:P1();break;
		case 2:P2();break;
		case 3:P3();break;
		default :exit(0);break;
	}
}
void view()//����ͼ��
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("�����㵽����զ���ң�����\n\n");
    printf("[1]������\n[2]������\n[3]���۸�\n");
    printf("[0]����\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:manage();break;
		case 1:J1();break;
		case 2:J2();break;
		case 3:J3();break;
		default :exit(0);break;
	}
}
void amend()//ͼ����Ϣɾ���޸�
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("�����㵽�����ɶ������\n\n");
    printf("[1]ɾ��\n[2]�޸�\n");
    printf("[0]����\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:manage();break;
		case 1:M1();break;
		case 2:M2();break;
		default :exit(0);break;
	}
}
void P1()//��1
{
	FILE*fp;
	int i;
	fp=fopen("apc.txt","r");
	for(i=0;i<sum;i++)
	{
		fscanf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,&BOOK[i].M,BOOK[i].print,&BOOK[i].time,&BOOK[i].price,BOOK[i].student,&BOOK[i].shijian);
	}
	fclose(fp);
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("������������\n");
	std::sort(BOOK,BOOK+sum,c1);
	for(i=0;i<sum;i++)
	{
		printf("%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
	}
	system("pause");
	manage();
}
void P2()//��2
{
	FILE*fp;
	int i;
	fp=fopen("apc.txt","r");
	for(i=0;i<sum;i++)
	{
		fscanf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,&BOOK[i].M,BOOK[i].print,&BOOK[i].time,&BOOK[i].price,BOOK[i].student,&BOOK[i].shijian);
	}
	fclose(fp);
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("�����߼�����\n");
	std::sort(BOOK,BOOK+sum,c2);
	for(i=0;i<sum;i++)
	{
		printf("%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
	}
	system("pause");
	manage();
}
void P3()//��3
{
	FILE*fp;
	int i;
	fp=fopen("apc.txt","r");
	for(i=0;i<sum;i++)
	{
		fscanf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,&BOOK[i].M,BOOK[i].print,&BOOK[i].time,&BOOK[i].price,BOOK[i].student,&BOOK[i].shijian);
	}
	fclose(fp);
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("���۸������\n");
	std::sort(BOOK,BOOK+sum,c3);
	for(i=0;i<sum;i++)
	{
		printf("%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
	}
	system("pause");
	manage();
}
void J3()
{
	system("cls");
	int j,o,l=0;
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("���������ҵļ۸�\n");
	scanf("%d",&o);
    printf("С���ǣ������ң�����\n");
	for(j=0;j<sum;j++)
	{
		if(o==BOOK[j].price)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("û���Ȿ�飬�����������\n");
	system("pause");
	manage();
}
void J2()
{
	system("cls");
	int j,l=0;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("���������ҵ����ߣ�\n");
	scanf("%s",o);
	printf("С���ǣ������ң�����\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].writer)==0)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("û���Ȿ�飬�����������\n");
	system("pause");
	manage();
}
void J1()
{
	system("cls");
	int j,l=0;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("���������ҵ�������\n");
	scanf("%s",o);
	printf("С���ǣ������ң�����\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("û���Ȿ�飬�����������\n");
	system("pause");
	manage();
}
void M1()//ɾ��
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("��������ɾ��������\n");
	scanf("%s",o);
	printf("С���ǣ������ң�����\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0)
		{
			l=j;
			break;
		}
	}
	if(l!=-1)
	{
		std::swap(BOOK[l],BOOK[sum-1]);
		memset(&BOOK[sum-1],0,sizeof(BOOK[sum-1]));
		sum-=1;
		printf("�鼮��ɾ����\n");
		for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("û���Ȿ�飬�����������\n");
	system("pause");
	manage();
}
void M2()//�޸�
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("�������������,�۸�\n");
	scanf("%s %d",o,&e);
	printf("С���ǣ������ң�����\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0&&e==BOOK[j].price)
		{
			l=j;
			break;
		}
	}
	if(l!=-1)
	{
		printf("������������ ������ ����� ���浥λ ����ʱ�� �۸� �ĸ�ѧ�����\n");
		printf("�����鼮���ƣ�\n");
		scanf("%s",BOOK[l].bookname);
		printf("������������\n");
		scanf("%s",BOOK[l].writer);
		printf("�������ţ�\n");
		scanf("%d",&BOOK[l].M);
		printf("������浥λ��\n");
		scanf("%s",BOOK[l].print);
		printf("�������ʱ�䣺\n");
		scanf("%d",&BOOK[l].time);
		printf("����۸�\n");
		scanf("%f",&BOOK[l].price);
		printf("�����ĸ�ѧ����ģ�\n");
		scanf("%s",BOOK[l].student);
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("û���Ȿ�飬����������أ�\n");
	system("pause");
	manage();
}
void GXGMM()
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	char E[20];
	FILE*fp;
	fp=fopen("apc1.txt","w+");
	printf("���������룺\n");
	scanf("%s",E);
	fprintf(fp,"%s",E);
	fclose(fp);
	printf("�޸���ɣ������������ת������Աϵͳ��\n");
	system("pause");
	manage();
}
void borrow()//��
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e,t;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("��������������,�����,�۸�\n");
	scanf("%s %d%d",o,&t,&e);
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0&&e==BOOK[j].price&&t==BOOK[j].M)
		{
			l=j;
			break;
		}
	}
	if(l!=-1)
	{
		strcpy(BOOK[j].student,SMM);
		printf("���ѽ��ĳɹ��������������ѧ��ϵͳ����ҳ��\n");
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("û���Ȿ�飬����������أ�\n");
	system("pause");
	student();
}
void bring()//��
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e,t;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("�������뻹������,�����,�۸�\n");
	scanf("%s %d%d",o,&t,&e);
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0&&e==BOOK[j].price&&t==BOOK[j].M)
		{
			l=j;
			break;
		}
	}
	if(l!=-1)
	{
		strcpy(BOOK[j].student,SMM);
		printf("���ѹ黹�ɹ���\n");
		printf("����黹ʱ�䣺\n");
		scanf("%d",&BOOK[l].shijian);
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("û���Ȿ�飬����������أ�\n");
	system("pause");
	student();
}
void search()//ѧ����ѯ
{
	int  j,r=0;
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("ϵͳΪ����ҽ�����£�\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(SMM,BOOK[j].student)==0&&BOOK[j].shijian!=0)
		{
			r++;
			printf("%s %s %d %s %d %f %s %d\n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(r)printf("��ѯ��ϣ������������\n");
	else
		printf("���������ˣ��������ɣ�WTF����\n");
	system("pause");
	student();
}
