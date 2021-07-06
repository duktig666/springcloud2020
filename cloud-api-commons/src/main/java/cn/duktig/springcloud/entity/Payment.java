package cn.duktig.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description:支付实体
 *
 * @author RenShiWei
 * Date: 2021/7/6 21:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    /**
     * 支付流水号
     */
    private String serial;
}

