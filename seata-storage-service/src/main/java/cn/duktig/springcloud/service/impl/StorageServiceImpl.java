package cn.duktig.springcloud.service.impl;

import cn.duktig.springcloud.entity.Storage;
import cn.duktig.springcloud.mapper.StorageMapper;
import cn.duktig.springcloud.service.IStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description:库存业务实现
 *
 * @author RenShiWei
 * Date: 2021/7/17 14:13
 **/
@Slf4j
@RequiredArgsConstructor
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {

    private final StorageMapper storageMapper;

    /**
     * 减库存
     *
     * @param productId 商品id
     * @param count     数量
     */
    @Override
    public void decrease(Long productId, Integer count) {
        int updateCount = storageMapper.decrease(productId, count);
        if (updateCount <= 0) {
            throw new RuntimeException("减库存失败");
        }
    }

}

