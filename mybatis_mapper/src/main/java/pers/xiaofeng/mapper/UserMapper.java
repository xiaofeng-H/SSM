package pers.xiaofeng.mapper;

import pers.xiaofeng.domain.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.UserMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 15:14
 */
public interface UserMapper {
    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> integers);
}
