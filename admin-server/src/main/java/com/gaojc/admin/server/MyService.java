package com.gaojc.admin.server;

import org.springframework.stereotype.Service;

/**
 * @author gaojc
 * @date 2019/5/6 23:45
 */
@Service("a")
public class MyService implements IService {
    @Override
    public void say() {
        System.out.println(1);
    }
}
