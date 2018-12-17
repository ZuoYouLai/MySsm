package com.jmp.comm;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @date: 2018-05-14 15:24
 */
public class ParseJSONParameterFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.setCharacterEncoding("UTF-8");
        // 获取请求头参数,判断请求参数是否为json格式;
        String contentType = httpServletRequest.getHeader("Content-Type");
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/json;charset=UTF-8");
        //TODO
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        if(StringUtils.isNotBlank(contentType) && contentType.startsWith("application/json")) {
             chain.doFilter(new PrettyFacesWrappedRequest((HttpServletRequest)request), response);
        } else {
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

}
