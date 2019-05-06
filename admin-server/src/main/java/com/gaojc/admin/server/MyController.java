package com.gaojc.admin.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author gaojc
 * @date 2019/5/6 23:47
 */
@RestController
@RequestMapping("/gaojc")
public class MyController implements ApplicationContextAware {
    private Map<String, IService> map = new HashMap<>();

    private IService iService;

    public void setiService(IService iService) {
        this.iService = iService;
    }

    void doSay() {
        this.iService.say();
    }

    @GetMapping("/{name}")
    public void test(@PathVariable("name") String name) {
        System.out.println("----test-----");

        map.forEach((k, v) -> {
            String key = k;
            IService value = v;
            if (name.equals(key)) {
                this.setiService(value);
            } else {
                this.setiService(null);
            }
            System.out.println(key + "," + v);
        });

        if (Objects.nonNull(iService)) {
            doSay();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        map.putAll(applicationContext.getBeansOfType(IService.class));
    }
}
