package cn.duktig.springcloud.feign;

import cn.duktig.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:storage远程服务接口
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:25
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageFeign {
    /**
     * 减少库存
     *
     * @param productId 商品id
     * @param count     数量
     * @return /
     */
    @PutMapping(value = "/storage/decrease")
    CommonResult<Void> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
