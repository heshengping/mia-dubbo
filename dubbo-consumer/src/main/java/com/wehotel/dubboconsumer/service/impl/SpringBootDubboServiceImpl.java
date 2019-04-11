package com.wehotel.dubboconsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wehotel.dubboapi.service.DemoService;
import com.wehotel.dubboconsumer.service.SpringBootDubboService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SpringBootDubboServiceImpl
 * @Description application.properties 配置dubbo，注解@Reference注册服务
 * @Author mia.he
 * @Date 2019/4/10
 * @Version 1.0
 */
@Service
public class SpringBootDubboServiceImpl implements SpringBootDubboService {
    @Reference
    DemoService demoService;
    @Override
    public String get() {
        return demoService.getPermissions(2).get(0);
    }
}
