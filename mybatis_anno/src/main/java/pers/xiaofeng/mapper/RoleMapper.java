package pers.xiaofeng.mapper;

import org.apache.ibatis.annotations.Select;
import pers.xiaofeng.dao.Role;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.RoleMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-02 10:11
 */
public interface RoleMapper {

    @Select("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = #{uid}")
    public List<Role> findRoleByUid(int uid);
}
