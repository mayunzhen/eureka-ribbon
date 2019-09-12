package com.study.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * EurekaRibbonService
 * 服务消费者服务类，调用服务提供者提供的服务，实现业务
 *
 * @author mayunzhen
 * @version 1.0.0
 */
@Service
public class EurekaRibbonService {
    @Autowired
    RestTemplate restTemplate;

    /**
     *  加入了@HystrixCommand注解，并设置了服务调用失败的回调方法 fallbackMethod = "getInfoFailure"
     * @return
     */
    @HystrixCommand(fallbackMethod = "getInfoFailure")
    public String getInfo() {
        String message;
        try {
            System.out.println("调用 服务 EUREKA-CLIENT/info");
            message = restTemplate.getForObject("http://EUREKA-CLIENT/info", String.class);
            System.out.println("服务 EUREKA-CLIENT/info 返回信息 : " + message);
            System.out.println("调用 服务 EUREKA-CLIENT/info 成功！");
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
    /**
     * 服务 EUREKA-PROVIDER/hello 调用失败的回调方法
     *
     * @return
     */
    public String getInfoFailure() {
        String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
}
