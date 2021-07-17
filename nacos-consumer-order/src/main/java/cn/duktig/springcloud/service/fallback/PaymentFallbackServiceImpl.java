package cn.duktig.springcloud.service.fallback;

import cn.duktig.springcloud.entity.Payment;
import cn.duktig.springcloud.vo.CommonResult;
import org.springframework.stereotype.Component;
import cn.duktig.springcloud.service.PaymentService;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 21:21
 **/
@Component
public class PaymentFallbackServiceImpl implements PaymentService {


    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<>(444, "fallback");
    }
}

