package cn.duktig.springcloud.controller;

import cn.duktig.springcloud.service.IStorageService;
import cn.duktig.springcloud.vo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:17
 **/
@RequiredArgsConstructor
@RequestMapping("storage")
@RestController
public class StorageController {
    private final IStorageService storageService;

    @PutMapping("/decrease")
    public CommonResult<Void> create(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "库存扣除成功");
    }
}

