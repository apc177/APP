#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<algorithm>
#include<windows.h>
int x;//执行操作
int sum=0;/*记录储存几个书籍信息了*/
char SMM[10];/*记录当前学生名字*/
struct book
{
	char bookname[20];//书名
	char writer[20];//作者名
	int M;//分类号
	char print[20];//出版单位
	int time;//出版时间
	float price;//价格
	char student[10];//哪个学生借的
	int shijian;//借阅时间
}BOOK[1001];
struct stt 
{
	char name[20];
	struct stt *next;
};
struct stt *head=NULL;
void land();//主页面
void menu1();//管理员登陆菜单
void menu2();//学生登陆菜单
void manage();//管理员系统
void enter();//图书信息录入
void browse();//图书信息浏览
void view();//图书查询
void amend();//图书信息修改删除
void student();//学生系统
void borrow();//学生借阅
void bring();//学生归还
void search();//学生查询
void P1();
void P2();
void P3();//检索
void J1();
void J2();
void J3();//查找
void M1();//删除
void M2();//修改
void GXGMM();//管理员修改密码
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
	MessageBoxA(0,"欢迎使用！","图书管理系统",0);
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
void land()//主界面
{
	system("cls");
	system("color 06");
	printf("*************************欢迎使用图书管理系统*************************\n");
	printf("请输入项目前编号执行相关操作：\n");
	printf("管理员[1]                学生[2]                退出系统[0]\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:printf("系统已退出，谢谢使用\n");exit(0);break;
		case 1: menu1();break;
		case 2: menu2();break;
		default :exit(0);break;
	}
}
void menu1()//管理员登陆
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
	printf("请输入管理员密码：\n");
	scanf("%s",GMM);
	if(strcmp(MM,GMM)==0)
	{
		printf("恭喜您登陆成功！\n");
		printf("----------------------------------------------------------------------\n");
		printf("请输入项目前编号执行相关操作：\n\n");
		printf("[0]进入系统\n[1]修改密码\n");
		scanf("%d",&z);
		switch(z)
		{
		case 0:manage();break;
		case 1:GXGMM();break;
		}
	}
	else
	{
		printf("输入错误，返回菜单\n");
		system("pause");
		land();
	}
}
void menu2()//学生登陆
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
	printf("请输入你的名字：\n");
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
	if(flag)printf("同学恭喜你登陆成功，按任意键自动为你跳转学生系统页面！\n");
	else 
	{
		printf("新同学你好\n");
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
void manage()//管理员操作系统
{
	system("cls");
	system("color 06");
	printf("----------------------------------------------------------------------\n");
    printf("请输入项目前编号执行相关操作：\n\n");
    printf("[1]图书信息录入\n[2]图书信息浏览\n[3]图书查询\n[4]图书信息修改\n");
    printf("[0]返回主页\n");
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
void  student()//学生操作系统
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("请输入项目前编号执行相关操作：\n\n");
    printf("[1] 借阅图书\n[2] 归还图书\n[3] 查询\n");
    printf("[0] 返回主页\n");
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
void enter()//图书信息录入
{
	system("cls");
	int k,i;
	printf("录入几本书的图书信息：\n");
	scanf("%d",&k);
	getchar();//清除缓存区
	FILE*fp;
	fp=fopen("apc.txt","a+");
	for(i=sum;i<sum+k;i++)
	{
		printf("输入书籍名称：\n");
		scanf("%s",BOOK[i].bookname);
		printf("输入作者名：\n");
		scanf("%s",BOOK[i].writer);
		printf("输入分类号：\n");
		scanf("%d",&BOOK[i].M);
		printf("输入出版单位：\n");
		scanf("%s",BOOK[i].print);
		printf("输入出版时间：\n");
		scanf("%d",&BOOK[i].time);
		printf("输入价格：\n");
		scanf("%f",&BOOK[i].price);
		printf("输入哪个学生借的：\n");
		scanf("%s",BOOK[i].student);
		BOOK[i].shijian=0;
		fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		printf("---------------------------------------------------------------------\n");
		printf("\n");
	}
	sum+=k;
	fclose(fp);
	printf("录入完毕，按任意键返回\n");
	system("pause");
	manage();
}
void browse()//图书信息浏览
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("请问你到底想咋浏览？？？\n\n");
    printf("[1]按书名浏览\n[2]按作者浏览\n[3]按价格浏览\n");
    printf("[0]返回\n");
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
void view()//查找图书
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("请问你到底想咋查找？？？\n\n");
    printf("[1]按书名\n[2]按作者\n[3]按价格\n");
    printf("[0]返回\n");
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
void amend()//图书信息删除修改
{
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
    printf("请问你到底想干啥？？？\n\n");
    printf("[1]删除\n[2]修改\n");
    printf("[0]返回\n");
	scanf("%d",&x);
	switch(x)
	{
		case 0:manage();break;
		case 1:M1();break;
		case 2:M2();break;
		default :exit(0);break;
	}
}
void P1()//排1
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
    printf("按书名检索：\n");
	std::sort(BOOK,BOOK+sum,c1);
	for(i=0;i<sum;i++)
	{
		printf("%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
	}
	system("pause");
	manage();
}
void P2()//排2
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
    printf("按作者检索：\n");
	std::sort(BOOK,BOOK+sum,c2);
	for(i=0;i<sum;i++)
	{
		printf("%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
	}
	system("pause");
	manage();
}
void P3()//排3
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
    printf("按价格检索：\n");
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
	printf("输入你想找的价格：\n");
	scanf("%d",&o);
    printf("小的们，给我找！！！\n");
	for(j=0;j<sum;j++)
	{
		if(o==BOOK[j].price)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("没有这本书，按任意键返回\n");
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
	printf("输入你想找的作者：\n");
	scanf("%s",o);
	printf("小的们，给我找！！！\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].writer)==0)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("没有这本书，按任意键返回\n");
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
	printf("输入你想找的书名：\n");
	scanf("%s",o);
	printf("小的们，给我找！！！\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(o,BOOK[j].bookname)==0)
		{
			l++;
			printf("%s %s %d %s %d %f %s %d \n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(l==0)printf("没有这本书，按任意键返回\n");
	system("pause");
	manage();
}
void M1()//删除
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("输入你想删的书名：\n");
	scanf("%s",o);
	printf("小的们，给我找！！！\n");
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
		printf("书籍已删除！\n");
		for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("没有这本书，按任意键返回\n");
	system("pause");
	manage();
}
void M2()//修改
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("输入你想的书名,价格：\n");
	scanf("%s %d",o,&e);
	printf("小的们，给我找！！！\n");
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
		printf("重新输入书名 作者名 分类号 出版单位 出版时间 价格 哪个学生借的\n");
		printf("输入书籍名称：\n");
		scanf("%s",BOOK[l].bookname);
		printf("输入作者名：\n");
		scanf("%s",BOOK[l].writer);
		printf("输入分类号：\n");
		scanf("%d",&BOOK[l].M);
		printf("输入出版单位：\n");
		scanf("%s",BOOK[l].print);
		printf("输入出版时间：\n");
		scanf("%d",&BOOK[l].time);
		printf("输入价格：\n");
		scanf("%f",&BOOK[l].price);
		printf("输入哪个学生借的：\n");
		scanf("%s",BOOK[l].student);
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("没有这本书，按任意键返回！\n");
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
	printf("输入新密码：\n");
	scanf("%s",E);
	fprintf(fp,"%s",E);
	fclose(fp);
	printf("修改完成！，按任意键跳转到管理员系统。\n");
	system("pause");
	manage();
}
void borrow()//借
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e,t;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("输入你想借的书名,分类号,价格：\n");
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
		printf("您已借阅成功，按任意键返回学生系统操作页面\n");
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("没有这本书，按任意键返回！\n");
	system("pause");
	student();
}
void bring()//还
{
	FILE*fp=fopen("apc.txt","w+");
	system("cls");
	int j,l=-1,e,t;
	char o[10];
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("输入你想还的书名,分类号,价格：\n");
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
		printf("您已归还成功！\n");
		printf("输入归还时间：\n");
		scanf("%d",&BOOK[l].shijian);
			for(int i=0;i<sum;i++)
		{
			fprintf(fp,"%s %s %d %s %d %f %s %d \n",BOOK[i].bookname,BOOK[i].writer,BOOK[i].M,BOOK[i].print,BOOK[i].time,BOOK[i].price,BOOK[i].student,BOOK[i].shijian);
		}
		fclose(fp);
	}
	else
		printf("没有这本书，按任意键返回！\n");
	system("pause");
	student();
}
void search()//学生查询
{
	int  j,r=0;
	system("cls");
	system("color 06");
	printf("---------------------------------------------------------------------\n");
	printf("系统为你查找结果如下：\n");
	for(j=0;j<sum;j++)
	{
		if(strcmp(SMM,BOOK[j].student)==0&&BOOK[j].shijian!=0)
		{
			r++;
			printf("%s %s %d %s %d %f %s %d\n",BOOK[j].bookname,BOOK[j].writer,BOOK[j].M,BOOK[j].print,BOOK[j].time,BOOK[j].price,BOOK[j].student,BOOK[j].shijian);
		}
	}
	if(r)printf("查询完毕，按任意键返回\n");
	else
		printf("你来借书了？你新生吧？WTF？？\n");
	system("pause");
	student();
}
