package mysql;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class expressmysql {
    private static QueryRunner queryRunner = new QueryRunner(JDPC.getDataSource());

    public expressmysql() {
    }

    public boolean insert(express sss) throws Exception {
        String sql = "insert into express (courier,addressee," +
                "sender,waybill,company,telephone,address,picture,delytime," +
                "recetime,remarks) values (?,?,?,?,?,?,?,?,?,?)";//插入
        Object[] ob={sss.getCourier(),sss.getAddressee(),sss.getSender(),sss.getWaybill(),
                sss.getCompany(),sss.getTelephone(),sss.getAddress(),sss.getPicture(),sss.getDelytime(),
                sss.getRecetime(),sss.getRemarks()};
        return queryRunner.update(sql,ob)!=0;
    }//插入

    public boolean insert1(express sss) throws Exception {
        String sql = "insert into express (id,courier,addressee,sender,waybill,company,telephone,address,picture,delytime,recetime,remarks) values (?,?,?,?,?,?,?,?,?,?,?)";//插入
        Object[] ob={sss.getId(),
                sss.getCourier(),sss.getAddressee(),sss.getSender(),sss.getWaybill(),
                sss.getCompany(),sss.getTelephone(),sss.getAddress(),sss.getPicture(),sss.getDelytime(),
                sss.getRecetime(),sss.getRemarks()};
        return queryRunner.update(sql,ob)!=0;
    }
    public boolean insert(String name, String remarks,String image,String tel,String company,String sender,String address,String addressee) throws Exception {
        //data:{"name":uname,"remarks":ramark,"image":imageurl,"tel":telephone,"company":company,"sender":sender,"address":address},
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println();
        String sql = "insert into express (waybill,courier,addressee,company,telephone,address,picture,remarks,sender,delytime) values (?,?,?,?,?,?,?,?,?,?)";//插入
        Object[] ob={String.valueOf(System.currentTimeMillis()),name,addressee,company,tel,address,image,remarks,sender,df.format(new Date())};
        return queryRunner.update(sql,ob)!=0;
    }

    public int querysome() throws Exception {
        String sql = "select count(*) from express";
        Object query = queryRunner.query(sql, new ScalarHandler<>());//0:成功      1：失败
        int a=query.hashCode();
        return a;
    }//查询总数

    public int querysomecount(String na) throws Exception {
        String sql = "select count(*) from express where courier like ?";
        Object ob=na;
        Object query = queryRunner.query(sql, new ScalarHandler<>(),ob);//0:成功      1：失败
        int a=query.hashCode();
        return a;
    }//查询某个人总 单数



    public List<express> querysome(int m, int n) throws Exception {
        if(querysome()!=0) {
            String sql = "select distinct * from express limit ?,?";
            Object[] ob = new Object[]{m * n, n};//m第几页    n每页多少个
            List<express> list = queryRunner.query(sql, new BeanListHandler<express>(express.class), ob);

            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
        else {
            return null;
        }
    }//查询
    public List<express> querysome(String name) throws Exception {
        if(querysome()!=0) {
            String sql = "SELECT * FROM express where courier=?";
            Object[] ob = new Object[]{name};
            List<express> list = queryRunner.query(sql, new BeanListHandler<express>(express.class), ob);

            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
        else {
            return null;
        }
    }//查询
    public boolean delsome(int id) throws SQLException {
        String sql="DELETE FROM express WHERE id=?";
        Object[] ob = new Object[]{id};//m第几页     n每页多少个

        return queryRunner.update(sql,ob)!=0;
    }
    public boolean qianshou(int id) throws SQLException {
        String sql="UPDATE express set recetime=? WHERE id=?";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Object[] ob = new Object[]{df.format(new Date()),id};//m第几页     n每页多少个
        return queryRunner.update(sql,ob)!=0;
    }
    public List<express> querysome(String name,String other) throws Exception {
        if(querysome()!=0) {
            String sql = "SELECT\n" +
                    "\t*\n" +
                    "FROM\n" +
                    "\texpress \n" +
                    "WHERE\n" +
                    "\tcourier = ?\n" +
                    "\tAND (company LIKE ?\n" +
                    "\tOR  sender LIKE ?\n" +
                    "\tOR  address LIKE ?)";
            Object[] ob = new Object[]{name,"%"+other+"%","%"+other+"%","%"+other+"%"};
            List<express> list = queryRunner.query(sql, new BeanListHandler<express>(express.class), ob);

            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
        else {
            return null;
        }
    }//查询
    public List<express> querysome2(String name,String other) throws Exception {
        if(querysome()!=0) {
            String sql = "SELECT\n" +
                    "\t*\n" +
                    "FROM\n" +
                    "\texpress \n" +
                    "WHERE\n" +
                    "\trecetime is NULL\n" +
                    "\tAND courier = ?\n" +
                    "\tAND (company LIKE ?\n" +
                    "\tOR  sender LIKE ?\n" +
                    "\tOR  address LIKE ?)";
            Object[] ob = new Object[]{name,"%"+other+"%","%"+other+"%","%"+other+"%"};
            List<express> list = queryRunner.query(sql, new BeanListHandler<express>(express.class), ob);

            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
        else {
            return null;
        }
    }//查询
    public List<express> querysome(String na, int m, int n) throws Exception {
        if(querysomecount(na)!=0) {
            String sql = "select distinct * from express where courier like ? limit ?,?";
            Object[] ob = new Object[]{na,m * n, n};//m第几页     n每页多少个
            List<express> list = queryRunner.query(sql, new BeanListHandler<express>(express.class), ob);
            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
        else {
            return null;
        }
    }//这个人丹书分页查询


    public boolean delete(int id) throws Exception {
        //获取

        String sql = "delete  from express where id=?";

        Object[] ob={id};
        return queryRunner.update(sql,ob)!=0;
    }//删除s

    public boolean updates(express sss, int id) throws Exception {//sss 改成后    改的id
        //获取
        String sql = "update express set id=?,courier=?,addressee=?,sender=?,waybill=?," +
                "company=?,telephone=?,address=?,picture=?,delytime=?,recetime=?,remarks=?" +
                "where id=?";
        Object[] ob={id,
                sss.getCourier(),sss.getAddressee(),sss.getSender(),sss.getWaybill(),
                sss.getCompany(),sss.getTelephone(),sss.getAddress(),sss.getPicture(),sss.getDelytime(),
                sss.getRecetime(),sss.getRemarks(),id};
        return queryRunner.update(sql,ob)!=0;
    }//修改
    public boolean updates_justremarks(int id,String remarks) throws Exception {//sss 改成后    改的id
        //获取
        String sql = "update express set remarks=? where id=?";
        Object[] ob={remarks, id};
        return queryRunner.update(sql,ob)!=0;
    }//修改
}
