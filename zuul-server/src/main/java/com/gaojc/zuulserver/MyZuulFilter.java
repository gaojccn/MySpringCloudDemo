package com.gaojc.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //pre:在请求之前过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    //过滤器的优先级，值越小，优先级越高
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //true表示需要执行过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("sessionId");
        if (accessToken == null) {
            log.warn("sessionId must not be empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("sessionId must not be empty");
            } catch (Exception e) {
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
