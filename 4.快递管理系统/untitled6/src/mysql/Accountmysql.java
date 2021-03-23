package mysql;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class Accountmysql {
    private static QueryRunner queryRunner = new QueryRunner(JDPC.getDataSource());

    public boolean insert(String username, String pwd) throws Exception {
        //获取
        String sql1="select count(*) from Login where Username =?";
        String sql= "insert into  Login (Username,passwd) values (?,?)";//插入
        Object[] ob=new Object[]{username,pwd};
        Object query = queryRunner.query(sql1, new ScalarHandler<>(),ob[0]);//0:成功      1：失败
        int a=query.hashCode();
        if(a==0){
            int a1=queryRunner.update(sql,ob);//0:插入成功      1：插入失败
            return a1!=0;
        }else {
            return false;
        }
    }//插入

    public List<SysUser> query()throws Exception{
        try {
            String sql = "select * from Login";
            //Object[] ob = new Object[]{1, 5};//第几页   每页多少个
            List<SysUser> list = queryRunner.query(sql, new BeanListHandler<>(SysUser.class));
            return list;
        }catch (Exception e){
         e.printStackTrace();
        }
        return null;
    }//查询
    public List<SysUser> querypart(String na, int m, int n) throws Exception {
        String sql=null;
        m--;
        sql = "select distinct * from Login where Username like ? limit ?,? ";
        Object[] ob=new Object[]{"%"+na+"%",m*n,n};//m第几页    n每页多少个
        List<SysUser> list= queryRunner.query(sql,new BeanListHandler<SysUser>(SysUser.class),ob);
        if(list.isEmpty()){
            list=null;
        }
        return list;
    }//查询
    public List<SysUser> querypart(String na) throws Exception {
        String sql=null;

        sql = "select distinct * from Login where Username like ? ";
        Object[] ob=new Object[]{"%"+na+"%"};//m第几页    n每页多少个
        List<SysUser> list= queryRunner.query(sql,new BeanListHandler<SysUser>(SysUser.class),ob);
        if(list.isEmpty()){
            list=null;
        }
        return list;
    }//查询
    public boolean update(String username, String pwd) throws Exception {
        //获取
        String sql= "update Login set Username=?,passwd=? where Username= ? ";//修改
        Object[] ob=new Object[]{username,pwd,username};
        int a=queryRunner.update(sql,ob);//0:修改成功      1：修改失败
        return a!=0;
    }//修改密码

    public boolean updateadmin(String username, String pwd,String name) throws Exception {
        //获取
        String sql= "update Login set Username=?,passwd=? where Username= ? ";//修改
        Object[] ob=new Object[]{username,pwd,name};
        int a=queryRunner.update(sql,ob);//0:修改成功      1：修改失败
        return a!=0;
    }//修改

    public boolean login(String username, String pwd) throws Exception{
        String sql = "select count(*) from Login where Username =? and passwd =?";//查找
        Object[] ob=new Object[]{username,pwd};
        //System.out.println(username);
        Object query = queryRunner.query(sql, new ScalarHandler<>(),ob);//0:成功      1：失败
        int a=query.hashCode();
        return a!=0;
    }//登录


//    public SysUser querylogin(String username)throws Exception{
//        String sql="select * from Login where Username =?";
//        Object ob=username;
//        SysUser sy= queryRunner.query(sql,new BeanHandler<SysUser>(SysUser.class), ob);
//        return sy;
//    }//登录查询

    public boolean delete(String username,String pwd) throws Exception{
        String sql="delete  from Login where Username=? and passwd=?";
        Object[] ob=new Object[]{username,pwd};
        int a=queryRunner.execute(sql,ob);//0:失败     1：成功
        return a!=0;
    }//删除

}
