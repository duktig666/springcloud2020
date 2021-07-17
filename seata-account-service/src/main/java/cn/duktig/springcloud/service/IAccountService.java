package cn.duktig.springcloud.service;

import cn.duktig.springcloud.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:11
 **/
public interface IAccountService extends IService<Account> {

    /**
     * 减余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    void decrease(Long userId, BigDecimal money);

}

