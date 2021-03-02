package pers.xiaofeng.dao;

import java.util.Date;
import java.util.List;

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

    // 描述的是当前用户具有的订单
    private List<Order> orderList;

    // 表示当前用户具备哪些角色
    private List<Role> roleList;

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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                '}';
    }

}
