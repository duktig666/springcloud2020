package cn.duktig.springcloud.feign;

import cn.duktig.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * description:Account远程服务接口
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:27
 **/
@FeignClient(value = "seata-account-service")
public interface AccountFeign {
    /**
     * 减少账号余额
     *
     * @param userId 用户id
     * @param money  余额
     * @return /
     */
    @PutMapping(value = "/account/decrease")
    CommonResult<Void> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
