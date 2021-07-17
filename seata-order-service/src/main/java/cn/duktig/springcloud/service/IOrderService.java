package cn.duktig.springcloud.service;

import cn.duktig.springcloud.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:11
 **/
public interface IOrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @param order 订单实体
     */
    void create(Order order);

}

