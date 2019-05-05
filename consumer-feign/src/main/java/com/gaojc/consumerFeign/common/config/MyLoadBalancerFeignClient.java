package com.gaojc.consumerFeign.common.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import feign.Client;
import feign.Request;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;

import java.io.IOException;
import java.net.URI;

/**
 * @author gaojc
 * @date 2019/4/28 22:20
 */
@Slf4j
public class MyLoadBalancerFeignClient extends LoadBalancerFeignClient {
    @Autowired
    private FeignURLProperties feignURLProperties;

    private DiscoveryClient discoveryClient;
    private Client delegate;
    private CachingSpringLoadBalancerFactory lbClientFactory;
    private SpringClientFactory clientFactory;

    public MyLoadBalancerFeignClient(Client delegate,
                                     CachingSpringLoadBalancerFactory lbClientFactory,
                                     SpringClientFactory clientFactory, DiscoveryClient discoveryClient) {
        super(delegate, lbClientFactory, clientFactory);

        this.delegate = delegate;
        this.lbClientFactory = lbClientFactory;
        this.clientFactory = clientFactory;
        this.discoveryClient = discoveryClient;

        log.info("my feign 负载均衡器初始化");
    }

    /**
     * @param request
     * @param options
     * @return
     * @throws IOException
     */
    @Override
    public Response execute(Request request, Request.Options options)
            throws IOException {
        String url = request.url();
        URI uri = URI.create(url);
        String clientName = uri.getHost();
        String headerPre = feignURLProperties.getHeaderPreName();

        //请求的客户名称转为小写
        String newUrl = null;

        // 从全局中获取该服务名称的配置信息
        IClientConfig clientConfig = this.clientFactory.getClientConfig(clientName);
        if (null != clientConfig) {
            // 配置当前服务的ip地址信息
//            clientConfig.set(CommonClientConfigKey.ListOfServers, mockProperties.getIpAddress());
            // 获取当前服务的负载均衡器，对当前服务的负载均衡器添加服务ip地址信息
            if (this.clientFactory.getLoadBalancer(clientName).getAllServers().isEmpty()) {
                ILoadBalancer loadBalancer = this.clientFactory.getLoadBalancer(clientName);

                System.out.println(loadBalancer);
                // addServers(Arrays.asList(new Server(mockServer[0], Integer.parseInt(mockServer[1]))));
            }

            // 重新构建请求 URL
            newUrl = url.replace(clientName, clientName + "_new");
            log.info("请求的 {} 服务已开启全局 mock 功能,服务地址：{}", clientName,
                    this.clientFactory.getLoadBalancer(clientName).getAllServers());
        }
        if (!request.headers().get(headerPre).isEmpty()) {
            newUrl = url.replace(clientName, clientName + "_new");
        }
        //重新构建 request　对象
        Request newRequest = Request.create(request.method(),
                newUrl, request.headers(), request.body(),
                request.charset());

        return super.execute(newRequest, options);
    }
}
