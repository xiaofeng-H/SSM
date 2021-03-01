package pers.xiaofeng.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.xiaofeng.dao.Order;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.OrderMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 18:05
 */
public interface OrderMapper {
    @Select("select *, o.id oid from orders o, user u where u.uid=o.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.uid"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password")
    })
    public List<Order> findAll();
}
