package pers.xiaofeng.dao;

import pers.xiaofeng.domain.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.dao.UserMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 14:21
 */
public interface UserMapper {
    /*
     * Mapper接口开发需要遵循一下规范:
     * 1>Mapper.xml文件中的namespace与mapper接口的全限定名相同
     * 2>Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
     * 3>Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType的类型相同
     * 4>Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
     * */
    List<User> findAll() throws Exception;

    User findById(int uid) throws Exception;
}
