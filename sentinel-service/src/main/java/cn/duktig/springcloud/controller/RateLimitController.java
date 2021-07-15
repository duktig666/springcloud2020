package cn.duktig.springcloud.controller;

import cn.duktig.springcloud.entity.Payment;
import cn.duktig.springcloud.handler.CustomerBlockHandler;
import cn.duktig.springcloud.vo.CommonResult;
import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 20:18
 **/
@RestController
public class RateLimitController {

    /**
     * 使用自定义的熔断处理方法
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }

    public CommonResult<Void> handleException(BlockException blockException) {
        return new CommonResult<>(444, blockException.getClass().getCanonicalName() + "\t服务不可用");
    }

    /**
     * 使用默认的熔断处理
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "by url限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }

    /**
     * 使用自定义的熔断处理
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "客户自定义 限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }

}

