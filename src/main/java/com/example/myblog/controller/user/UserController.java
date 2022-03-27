package com.example.myblog.controller.user;

import com.example.myblog.common.ResponseFactory;
import com.example.myblog.model.request.user.ConsoleLoginRequest;
import com.example.myblog.model.response.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public CommonResponse LogIn(@RequestBody ConsoleLoginRequest request) {
        System.out.println("=====>"+request.toString());
        return ResponseFactory.success();
    }
}
