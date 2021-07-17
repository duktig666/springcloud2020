package cn.duktig.springcloud.controller;

import cn.duktig.springcloud.entity.Order;
import cn.duktig.springcloud.service.IOrderService;
import cn.duktig.springcloud.vo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:17
 **/
@RequiredArgsConstructor
@RequestMapping("order")
@RestController
public class OrderController {
    private final IOrderService orderService;

    @PostMapping
    public CommonResult<Void> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}

