package pers.xiaofeng.domain;

/**
 * @className: pers.xiaofeng.domain.Account
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 17:32
 */
public class Account {

    /*
    * 数据库建表语句：
    CREATE TABLE `account` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(32) NOT NULL DEFAULT '',
        `money` double NOT NULL DEFAULT '0.0',
        PRIMARY KEY (`id`)
    )
    * */

    private Integer id;
    private String name;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
