package com.mcii.tools;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mcii.tools.exception.LoginException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常统一处理
 */

@Component
public class ExceptionHandler implements HandlerExceptionResolver{


    @Override
    public  @ResponseBody ModelAndView resolveException(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        e.printStackTrace();

        if (e instanceof LoginException) {
            String message = "尚未登录";
            mav.addObject("message",message);
            ResponseStatus status = ResponseStatus.FAIL;
            mav.addObject("status",status);
        }
        else{
            String message = "可能为其他错误";
            mav.addObject("message",message);
            ResponseStatus status = ResponseStatus.FAIL;
            mav.addObject("status",status);
        }
        mav.addObject("object", null);
        return mav;
    }
}
