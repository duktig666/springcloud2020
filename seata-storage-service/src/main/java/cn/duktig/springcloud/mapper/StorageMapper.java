package cn.duktig.springcloud.mapper;

import cn.duktig.springcloud.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:08
 **/
public interface StorageMapper extends BaseMapper<Storage> {

    @Update("update t_storage set used =used + #{count},residue=residue - #{count} " +
            " where product_id=#{productId};")
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

