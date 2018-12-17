package com.jmp.comm;

import com.jmp.comm.Utils.ResultUtils;
import com.jmp.jpojo.DefineException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
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
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            //自定义异常的处理操作
            DefineException target = (DefineException) ex;
            if (ex instanceof DefineException) {
                out.write(ResultUtils.failJSON(target.getMessage(), target.getErrorCode()).getBytes("UTF-8"));
                log.info("自定义的异常内容  ：  {}   code ： {}", target.getMessage(), target.getErrorCode());
            } else {
                response.getWriter().write(ResultUtils.failJSON(ex.getMessage()));
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
