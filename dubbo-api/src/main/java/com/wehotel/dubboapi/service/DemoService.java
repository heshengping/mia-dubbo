package com.wehotel.dubboapi.service;

import java.util.List;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author mia.he
 * @Date 2019/4/9
 * @Version 1.0
 */
public interface DemoService {
    List<String> getPermissions(int id);
}
