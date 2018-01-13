package com.gaole.mybatis.mapper;

import com.gaole.mybatis.entity.Orders;

import java.util.List;

/**
 * 订单接口
 *
 * @author gl
 */
public interface OrdersMapper {

    /**
     * 返回订单表中的所有数据
     *
     * @return
     */
    public List<Orders> findAll();

    List<Orders> queryOrdersUser();
}
