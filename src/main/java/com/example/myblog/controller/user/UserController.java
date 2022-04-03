package com.example.myblog.controller.user;

import com.example.myblog.common.ResponseFactory;
import com.example.myblog.convert.GetUserContextDTOConvert;
import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.request.user.ConsoleGetUserContextRequest;
import com.example.myblog.model.request.user.ConsoleLoginRequest;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.model.response.user.ConsoleGetUserContextResponse;
import com.example.myblog.service.user.IUserReadService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户
 * created by wangweijie14 on 2021/12/25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserReadService userReadService;

    @PostMapping("/login")
    public CommonResponse LogIn(@RequestBody ConsoleLoginRequest request) {
        System.out.println("=====>" + request.toString());
        return ResponseFactory.success();
    }

    @GetMapping("/getUserContext")
    public ConsoleGetUserContextResponse getUserContext(@RequestBody ConsoleGetUserContextRequest request) {
        UserBO userContext = userReadService.getUserContext(request.getAccount());
        return ResponseFactory.success(GetUserContextDTOConvert.toGetUserContextDTO(userContext),
                ConsoleGetUserContextResponse.class);

    }
}
