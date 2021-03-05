package pers.xiaofeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xiaofeng.domain.Account;
import pers.xiaofeng.mapper.AccountMapper;
import pers.xiaofeng.service.AccountService;

import java.util.List;

/**
 * @className: pers.xiaofeng.service.impl.AccountServiceImpl
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 17:36
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

}
