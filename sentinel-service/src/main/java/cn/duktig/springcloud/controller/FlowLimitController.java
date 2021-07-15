package cn.duktig.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/15 9:28
 **/
@RequestMapping("sentinel")
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        //通过线程睡眠，测试线程数达到阈值的限流
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testA   -----";
    }

    @GetMapping("/testB")
    public String testB() {
        //测试关联模式，B关联C，C超过阈值访问B，B访问失败
        return "testB   -----";
    }

    @GetMapping("/testC")
    public String testC() {
        log.info(Thread.currentThread().getName() + "...testB ");
        return "testC   -----";
    }

    @GetMapping("/testD")
    public String testD() {
        return "testD   -----";
    }

    @GetMapping("/testE")
    public String testE() {
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testE 测试【慢调用比例】");
        return "testE -----";
    }

    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testF 测试【异常比例】|【异常数】");
        int age = 10 / 0;
        return "testF -----";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        //如果抛出异常，按照正常的异常处理来走
        //int age = 10 / 0;
        return "testHotKey -----";
    }

    public String dealTestHotKey(String p1, String p2, BlockException blockException) {
        return "dealTestHotKey---------";
    }


}

