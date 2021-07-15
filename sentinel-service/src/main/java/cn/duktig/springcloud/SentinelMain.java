package cn.duktig.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 9:23
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMain.class, args);
    }

}

