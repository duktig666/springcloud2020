package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 支付模块启动类
 * EnableDiscoveryClient 开启服务发现
 * EnableFeignClients 启动openFeign
 *
 * @author RenShiWei
 * @date 2020/2/17 21:13
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderMain.class, args);
    }
}
