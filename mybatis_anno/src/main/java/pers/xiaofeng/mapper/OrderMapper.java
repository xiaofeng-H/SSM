package pers.xiaofeng.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.xiaofeng.dao.Order;
import pers.xiaofeng.dao.User;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.OrderMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 18:05
 */
public interface OrderMapper {

    /*@Select("select *, o.id oid from orders o, user u where u.uid=o.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.uid"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password")
    })
    public List<Order> findAll();*/

    // 以下相比于以上更常用
    @Select("select * from orders")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",      // 要封装的属性名称
                    column = "uid",         // 根据哪个字段去查询user表的数据
                    javaType = User.class,  // 要封装的实体类型
                    // select属性:代表查询哪个接口的方法获得数据
                    one = @One(select = "pers.xiaofeng.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();

    /**
     * 通过uid来查询订单（一对多）
     *
     * @param uid 订单所属用户的uid
     * @return
     */
    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUid(int uid);
}
