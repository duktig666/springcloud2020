package cn.duktig.springcloud.handler;

import cn.duktig.springcloud.vo.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * description:自定义的熔断策略
 *
 * @author RenShiWei
 * Date: 2021/7/15 20:17
 **/
public class CustomerBlockHandler {

    public static CommonResult<Void> handlerException(BlockException exception) {
        return new CommonResult<>(444, "客户自定义，global handlerException---1");
    }

    public static CommonResult<Void> handlerException2(BlockException exception) {
        return new CommonResult<>(444, "客户自定义，global handlerException---2");
    }

}

