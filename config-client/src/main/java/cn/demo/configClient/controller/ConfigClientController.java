package cn.demo.configClient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaojc on 2018/10/21.
 */
@RefreshScope //开启更新功能
@RestController
@Slf4j
public class ConfigClientController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/hi")
    public String hi() {
        log.info("config-client-sayHi");
        return foo;
    }

}
