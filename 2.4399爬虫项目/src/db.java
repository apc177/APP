import java.sql.*;
public class db {
    static {//静态代码块
        try {
            Class.forName("com.mysql.jdbc.Driver"); }
        catch (Exception e){
            e.printStackTrace(); } }
    public Connection getcon()throws Exception{
        String user="root",psw="1772149632";
        Connection temp = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/4399?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&amp;failOverReadOnly=false", user, psw);
        return temp;
    }
    public void close(Connection temp,PreparedStatement temp2)throws Exception{
        if(temp!=null)temp.close();
        if(temp2!=null)temp2.close();
    }
}
