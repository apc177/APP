package mysql;

import java.io.Serializable;
/**
 * user_info
 * @author 
 */
public class UserInfo implements Serializable {
    public UserInfo(){
    }
    private Integer userId;

    private String userName;

    private String userPwd;

    private String token;

    private static final long serialVersionUID = 1L;

    public UserInfo(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}