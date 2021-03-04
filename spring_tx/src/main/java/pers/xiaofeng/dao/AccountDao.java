package pers.xiaofeng.dao;

/**
 * @className: pers.xiaofeng.dao.AccountDao
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-03 14:19
 */
public interface AccountDao {

    public void out(String outMan, double money);

    public void in(String inMan, double money);

}
