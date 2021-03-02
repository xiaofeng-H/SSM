package pers.xiaofeng.mapper;

import org.apache.ibatis.annotations.*;
import pers.xiaofeng.dao.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.UserMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 17:09
 */
public interface UserMapper {

    @Insert("insert into user (uid, username, password) values (#{uid}, #{username}, #{password})")
    public void save(User user);

    @Update("update user set username=#{username}, password=#{password} where uid = ${uid}")
    public void update(User user);

    @Delete("delete from user where uid = #{uid}")
    public void delete(int uid);

    @Select("select * from user where uid = #{uid}")
    public User findById(int uid);

    @Select("select * from user")
    public List<User> findAll();

    /**
     * 一对多查询演示
     *
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "uid",
                    javaType = List.class,
                    many = @Many(select = "pers.xiaofeng.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();

    /**
     * 多对多查询演示
     *
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "uid",
                    javaType = List.class,
                    many = @Many(select = "pers.xiaofeng.mapper.RoleMapper.findRoleByUid")
            )
    })
    public List<User> findUserAndRoleALl();
}