package cn.duktig.springcloud.controller;

import cn.duktig.springcloud.entity.Payment;
import cn.duktig.springcloud.vo.CommonResult;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 20:30
 **/
@RestController
@Slf4j
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") //配置了fallback的，fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // 配置了blockHandler，只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})// 配置了blockHandler和fallback
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = restTemplate.getForObject(serverUrl + "/payment/nacos/" + id,
                CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (Objects.requireNonNull(commonResult).getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有记录，空指针异常");
        }
        return commonResult;
    }


    /**
     * 本例是fallback
     * 管Java异常
     */
    public CommonResult<Payment> handlerFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常handler，exception内容" + e.getMessage(), payment);
    }

    /**
     * 本例是blockHandler
     * 管熔断降级
     */
    public CommonResult<Payment> blockHandler(Long id, BlockException exception) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockHandler-sentinel 限流，无此流水号：blockException" + exception.getMessage(),
                payment);
    }

}

