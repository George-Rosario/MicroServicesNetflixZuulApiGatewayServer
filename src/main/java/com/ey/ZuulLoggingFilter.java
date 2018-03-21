package com.ey;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() throws ZuulException {
		//real logic of filter goes here
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} rquest URI -> {} ", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true; // should filter run or not
	}

	@Override
	public int filterOrder() {
		return 1; //change to 1 for order of filter
	}

	@Override
	public String filterType() {
		return "pre";  // should the request be intercepted before (pre) after (post) or error (error)
	}

}
