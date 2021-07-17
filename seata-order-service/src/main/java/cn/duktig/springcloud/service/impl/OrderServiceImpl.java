package cn.duktig.springcloud.service.impl;

import cn.duktig.springcloud.entity.Order;
import cn.duktig.springcloud.feign.AccountFeign;
import cn.duktig.springcloud.feign.StorageFeign;
import cn.duktig.springcloud.mapper.OrderMapper;
import cn.duktig.springcloud.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description:订单业务实现
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:13
 **/
@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final StorageFeign storageFeign;
    private final AccountFeign accountFeign;
    private final OrderMapper orderMapper;

    /**
     * 创建订单
     * 流程：创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     *
     * @param order 订单实体
     */
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        //1 新建订单
        orderMapper.insert(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageFeign.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务调用库存，做扣减end");

        int a = 10 / 0;

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountFeign.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }

}

