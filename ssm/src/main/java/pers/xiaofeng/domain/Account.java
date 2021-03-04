package pers.xiaofeng.domain;

/**
 * @className: pers.xiaofeng.domain.Account
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 17:32
 */
public class Account {

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
