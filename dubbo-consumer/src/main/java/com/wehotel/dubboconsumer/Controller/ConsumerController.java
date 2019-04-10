package com.wehotel.dubboconsumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wehotel.dubboapi.service.DemoService;
import com.wehotel.dubboconsumer.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author mia.he
 * @Date 2019/4/9
 * @Version 1.0
 */
@RestController
@RequestMapping(value="/dubbo")
public class ConsumerController {
    @Autowired
    private DubboService dubboService;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String getDemo(){
        return dubboService.get();
    }
}
