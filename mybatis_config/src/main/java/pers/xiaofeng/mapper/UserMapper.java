package pers.xiaofeng.mapper;

import pers.xiaofeng.domain.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.UserMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 17:41
 */
public interface UserMapper {
    public void save(User user) throws Exception;

    public User findById(int uid) throws Exception;
}
