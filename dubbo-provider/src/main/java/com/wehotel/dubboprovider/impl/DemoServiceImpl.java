package com.wehotel.dubboprovider.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.wehotel.dubboapi.service.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DemoServiceImpl
 * @Description application.properties 配置文件提供服务时，需加上注解@Service
 * @Author mia.he
 * @Date 2019/4/9
 * @Version 1.0
 */
@Service(interfaceClass = DemoService.class)
public class DemoServiceImpl implements DemoService {
    @Override
    public List<String> getPermissions(int id) {
        List<String> demo = new ArrayList<>();
        demo.add("========" + id);
        return demo;
    }
}
