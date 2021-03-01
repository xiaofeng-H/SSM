package pers.xiaofeng.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
}