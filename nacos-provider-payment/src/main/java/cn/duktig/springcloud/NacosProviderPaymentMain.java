package cn.duktig.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 支付模块启动类
 * EnableDiscoveryClient 开启服务发现
 *
 * @author RenShiWei
 * @date 2020/2/17 21:13
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosProviderPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentMain.class, args);
    }
}
