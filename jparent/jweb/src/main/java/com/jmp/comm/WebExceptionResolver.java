package com.jmp.comm;

import com.jmp.comm.Utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class WebExceptionResolver implements HandlerExceptionResolver {

    /**
     * web全局异常的处理操作
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv;
        String url = request.getRequestURL().toString();
        String defaultMsg = "System error";
        log.error("unknown json exception, url:" + url, ex);
        log.error("error occur exception:" + ex.getMessage(), ex);
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().write(ResultUtils.failJSON(ex.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
