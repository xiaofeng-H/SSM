package pers.xiaofeng.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pers.xiaofeng.dao.AccountDao;

import javax.annotation.Resource;

/**
 * @className: pers.xiaofeng.dao.impl.AccountDaoImpl
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-03 14:13
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, outMan);
    }

    @Override
    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, inMan);
    }
}
