package cn.duktig.springcloud.service;

import cn.duktig.springcloud.entity.Payment;
import cn.duktig.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cn.duktig.springcloud.service.fallback.PaymentFallbackServiceImpl;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 21:19
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/nacos/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}

