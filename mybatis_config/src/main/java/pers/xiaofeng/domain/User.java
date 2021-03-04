package pers.xiaofeng.domain;

import java.util.Date;

/**
 * @className: pers.xiaofeng.domain.User
 * @description: mybatis练习实体类，对应数据库user表
 * @author: xiaofeng
 * @create: 2021-02-25 17:50
 */
public class User {

    /*
    * 数据库建表语句：
    CREATE TABLE `user` (
        `uid` int(11) NOT NULL AUTO_INCREMENT,
        `username` varchar(32) NOT NULL DEFAULT '',
        `password` char(12) NOT NULL DEFAULT '',
        `birthday` bigint(20) DEFAULT NULL,
        PRIMARY KEY (`uid`)
    )
    * */

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
