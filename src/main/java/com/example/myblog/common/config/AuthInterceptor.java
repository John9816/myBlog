package com.example.myblog.common.config;

import com.example.myblog.common.utils.JsonUtil;
import com.example.myblog.common.utils.RedisUtil;
import com.example.myblog.model.Status;
import com.example.myblog.model.response.CommonResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

import static com.example.myblog.common.constant.UserErrorCodeEnum.*;

/**
 * token拦截
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Headers", "token, content-type");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");

        if (StringUtils.isEmpty(token) || Objects.isNull(redisUtil.get(token))) {
            CommonResponse commonResponse = new CommonResponse();
            Status status = new Status();
            status.setCode(TOKEN_INVALID.getCode());
            status.setMsg(TOKEN_INVALID.getMessage());
            commonResponse.setStatus(status);
            String data = JsonUtil.toJson(commonResponse);

            response.getWriter().print(data);
            return false;
        }
        Object loginStatus = redisUtil.get(token);
        if (Objects.isNull(loginStatus)) {
            CommonResponse commonResponse = new CommonResponse();
            Status status = new Status();
            status.setCode(TOKEN_INVALID.getCode());
            status.setMsg(TOKEN_INVALID.getMessage());
            commonResponse.setStatus(status);
            String data = JsonUtil.toJson(commonResponse);

            response.getWriter().print(data);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}

