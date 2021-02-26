package pers.xiaofeng.domain;

import java.util.Date;

/**
 * @className: pers.xiaofeng.domain.User
 * @description: mybatis练习实体类
 * @author: xiaofeng
 * @create: 2021-02-25 17:50
 */
public class User {

    private int uid;
    private String username;
    private String password;
    private Date birthday;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
