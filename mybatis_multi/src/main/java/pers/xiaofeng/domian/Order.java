package pers.xiaofeng.domian;

import java.util.Date;

/**
 * @className: pers.xiaofeng.domian.Order
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 13:59
 */
public class Order {
    private int id;
    private Date orderTime;
    private double total;

    // 当前订单属于哪一个用户
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
