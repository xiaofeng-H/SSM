package pers.xiaofeng.mapper;

import pers.xiaofeng.domian.Order;

import java.util.List;

/**
 * @className: pers.xiaofeng.mapper.OrderMapper
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 14:02
 */
public interface OrderMapper {
    public List<Order> findAll() throws Exception;
}
