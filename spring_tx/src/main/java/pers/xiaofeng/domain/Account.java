package pers.xiaofeng.domain;

/**
 * @className: pers.xiaofeng.domain.Account
 * @description: 账户类，对应数据库account表
 * @author: xiaofeng
 * @create: 2021-03-03 14:11
 */
public class Account {

    private String name;
    private double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
