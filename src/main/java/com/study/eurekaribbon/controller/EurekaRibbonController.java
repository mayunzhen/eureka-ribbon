package com.study.eurekaribbon.controller;

import com.study.eurekaribbon.service.EurekaRibbonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * EurekaRibbonController
 * 服务消费者控制器类，对用户提供服务
 *
 * @author mayunzhen
 * @version 1.0.0
 */
@RestController
public class EurekaRibbonController {

    @Resource
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("/ribbonInfo")
    public String ribbonInfo() {
        String message = eurekaRibbonService.getInfo();
        return "获取的信息:" + message;
    }

}