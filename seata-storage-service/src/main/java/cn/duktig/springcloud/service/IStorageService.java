package cn.duktig.springcloud.service;

import cn.duktig.springcloud.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:11
 **/
public interface IStorageService extends IService<Storage> {

    /**
     * 减库存
     *
     * @param productId 商品id
     * @param count     数量
     */
    void decrease(Long productId, Integer count);

}

