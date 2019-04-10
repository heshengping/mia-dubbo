package com.wehotel.dubboprovider.impl;

import com.wehotel.dubboapi.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DemoServiceImpl
 * @Description TODO
 * @Author mia.he
 * @Date 2019/4/9
 * @Version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public List<String> getPermissions(int id) {
        List<String> demo = new ArrayList<>();
        demo.add("========" + id);
        return demo;
    }
}
