package cn.duktig.springcloud.service.impl;

import cn.duktig.springcloud.entity.Account;
import cn.duktig.springcloud.mapper.AccountMapper;
import cn.duktig.springcloud.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * description:库存业务实现
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:13
 **/
@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    private final AccountMapper storageMapper;

    /**
     * 减余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        int updateCount = storageMapper.decrease(userId, money);
        if (updateCount <= 0) {
            throw new RuntimeException("减账户余额失败");
        }
    }
}

