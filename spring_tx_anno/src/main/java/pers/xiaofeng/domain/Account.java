package pers.xiaofeng.domain;

/**
 * @className: pers.xiaofeng.domain.Account
 * @description: 账户类，对应数据库account表
 * @author: xiaofeng
 * @create: 2021-03-03 14:11
 */
public class Account {

    /*
    * 数据库建表语句：
    CREATE TABLE `account` (
        `name` varchar(32) NOT NULL DEFAULT '',
        `money` BIGINT NOT NULL DEFAULT '0',
        PRIMARY KEY (`name`)
    )
    * */

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
