package pers.xiaofeng.mapper;

import pers.xiaofeng.domain.Account;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.AccountMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 17:33
 */
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();

}
