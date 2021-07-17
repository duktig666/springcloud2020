package cn.duktig.springcloud.controller;

import cn.duktig.springcloud.service.IAccountService;
import cn.duktig.springcloud.vo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:17
 **/
@RequiredArgsConstructor
@RequestMapping("account")
@RestController
public class AccountController {
    private final IAccountService accountService;

    @PutMapping("/decrease")
    public CommonResult<Void> create(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "账户余额扣除成功");
    }
}

