package com.wehotel.dubboconsumer.service.impl;

import com.wehotel.dubboapi.service.DemoService;
import com.wehotel.dubboconsumer.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DubboServiceImpl
 * @Description bak-applicationContext.xml 配置dubbo，注册服务 ，bean
 * @Author mia.he
 * @Date 2019/4/10
 * @Version 1.0
 */
@Service
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
