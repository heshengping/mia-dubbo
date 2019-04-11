package com.wehotel.dubboconsumer.Controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wehotel.dubboapi.service.DemoService;
import com.wehotel.dubboconsumer.service.DubboService;
import com.wehotel.dubboconsumer.service.SpringBootDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @Autowired
    private SpringBootDubboService springBootDubboService;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String getDemo(){
        return dubboService.get();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public String getSpringDemo(){
        return springBootDubboService.get();
    }

}
