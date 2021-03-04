package pers.xiaofeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xiaofeng.dao.AccountDao;
import pers.xiaofeng.service.AccountService;

import javax.annotation.Resource;

/**
 * @className: pers.xiaofeng.service.impl.AccountServiceImpl
 * @description: 目标对象 内部的方法就是切点
 * @author: xiaofeng
 * @create: 2021-03-03 14:25
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int i = 1 / 0;
        accountDao.in(inMan, money);
    }
}
