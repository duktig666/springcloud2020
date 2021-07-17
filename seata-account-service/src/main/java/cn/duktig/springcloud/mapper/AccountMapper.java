package cn.duktig.springcloud.mapper;

import cn.duktig.springcloud.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 17:02
 **/
public interface AccountMapper extends BaseMapper<Account> {

    @Update("update t_account set used =used + #{money},residue=residue-#{money} " +
            "where user_id=#{userId};")
    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}

