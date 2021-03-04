package pers.xiaofeng.service;

import pers.xiaofeng.domain.Account;

import java.util.List;

/**
 * @className: pers.xiaofeng.service.AccountService
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 17:35
 */
public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();

}
