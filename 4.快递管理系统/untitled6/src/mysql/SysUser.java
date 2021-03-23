package mysql;

public class SysUser {
    private  int id;
    private  String Username;
    private  String passwd;

    public SysUser() {
    }
    public SysUser(String Username,String passwd) {
        this.passwd=passwd;
        this.Username=Username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

}
