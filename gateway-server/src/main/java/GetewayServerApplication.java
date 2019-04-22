import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Geteway-server 服务启动类
 *
 * @author gaojc
 * @date 2019/4/22 23:57
 */
@SpringBootApplication
@ComponentScan("com.gaojc.geteway")
public class GetewayServerApplication {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(GetewayServerApplication.class, args);
    }

    @Bean
    public RouteLocatorBuilder routeLocatorBuilder() {
        return new RouteLocatorBuilder(context);
    }

}
