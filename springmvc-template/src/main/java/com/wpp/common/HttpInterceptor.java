package com.wpp.common;

import com.wpp.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wangpp
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    private static final String START_MILLIS = "startRequestMillis";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        request.setAttribute(START_MILLIS, System.currentTimeMillis());
        log.info("request start , uri:{},param:{}", uri, JsonMapper.obj2String(parameterMap));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Long start = (Long) request.getAttribute(START_MILLIS);
        Long time = System.currentTimeMillis() - start;
        log.info("request postHandle ，spend time: {} ms, uri:{},param:{}", time, uri, JsonMapper.obj2String(parameterMap));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Long start = (Long) request.getAttribute(START_MILLIS);
        Long time = System.currentTimeMillis() - start;
        log.info("request complete ,spend time: {} ms , uri:{},param:{}", time, uri, JsonMapper.obj2String(parameterMap));
    }
}
