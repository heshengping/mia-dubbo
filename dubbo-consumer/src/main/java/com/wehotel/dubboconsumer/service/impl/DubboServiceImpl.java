package com.wehotel.dubboconsumer.service.impl;

import com.wehotel.dubboapi.service.DemoService;
import com.wehotel.dubboconsumer.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName DubboServiceImpl
 * @Description TODO
 * @Author mia.he
 * @Date 2019/4/10
 * @Version 1.0
 */

public class DubboServiceImpl implements DubboService {

    private DemoService demoService;
    @Override
    public String get() {
        List<String> list =  demoService.getPermissions(2);
        return list.get(0);
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }
}
