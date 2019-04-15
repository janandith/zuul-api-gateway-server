package com.gmail.janandith.zuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class LoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() { // filter before or after the request has been executed or only error requests?
        return "pre";
    }

    @Override
    public int filterOrder() { // Priority order
        return 1;
    }

    @Override
    public boolean shouldFilter() { // should this filter be executed or not?
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request url -> {}", request, request.getRequestURL());

        return null;
    }
}
