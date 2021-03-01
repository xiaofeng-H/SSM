package pers.xiaofeng.mapper;

import pers.xiaofeng.domian.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.UserMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 13:57
 */
public interface UserMapper {
    public List<User> findAll() throws Exception;

    public List<User> findUserAndRoleAll() throws Exception;
}
