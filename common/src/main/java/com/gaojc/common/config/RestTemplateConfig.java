package com.gaojc.common.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gaojc.common.converter.TextMappingJackson2HttpMessageConverter;
import org.apache.commons.codec.Charsets;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author gaojc
 * @desc
 * @since 2019/1/22
 */

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setRequestFactory(clientHttpRequestFactory());
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.set(0, new TextMappingJackson2HttpMessageConverter());
        converters.set(1, new FastJsonHttpMessageConverter());
        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
        converters.set(2, new StringHttpMessageConverter(Charsets.UTF_8));

        return restTemplate;
    }

    @Bean
    public HttpClientConnectionManager poolingConnectionManager() {
        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
        poolingConnectionManager.setMaxTotal(1000); // 连接池最大连接数
        poolingConnectionManager.setDefaultMaxPerRoute(100); // 同路由的并发

        return poolingConnectionManager;
    }

    @Bean
    public HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //设置HTTP连接管理器
        httpClientBuilder.setConnectionManager(poolingConnectionManager());
        // 重试次数
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
        return httpClientBuilder;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClientBuilder().build());
        // 连接超时，毫秒
        clientHttpRequestFactory.setConnectTimeout(10 * 1000);
        // 读写超时，毫秒
        clientHttpRequestFactory.setReadTimeout(10 * 1000);
        // 连接不够用的等待时间
        clientHttpRequestFactory.setConnectionRequestTimeout(20 * 1000);
        return clientHttpRequestFactory;
    }

}
