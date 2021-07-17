package cn.duktig.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description:取消数据源的自动配置
 *
 * @author RenShiWei
 * Date: 2021/7/17 11:28
 **/
@MapperScan({
        "cn.duktig.springcloud.mapper",
})
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataAccountMain {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain.class, args);
    }

}

