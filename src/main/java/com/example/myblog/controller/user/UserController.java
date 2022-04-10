package com.example.myblog.controller.user;

import com.example.myblog.common.ResponseFactory;
import com.example.myblog.common.utils.RedisUtil;
import com.example.myblog.converter.GetUserContextDTOConvert;
import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.dto.user.ConsoleLoginDTO;
import com.example.myblog.model.request.user.ConsoleGetUserContextRequest;
import com.example.myblog.model.request.user.ConsoleLoginRequest;
import com.example.myblog.model.response.user.ConsoleGetUserContextResponse;
import com.example.myblog.model.response.user.ConsoleLoginResponse;
import com.example.myblog.service.user.IUserReadService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

import static com.example.myblog.common.constant.UserErrorCodeEnum.*;

/**
 * 用户
 * created by wangweijie14 on 2021/12/25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserReadService userReadService;

    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ConsoleLoginResponse LogIn(@RequestBody ConsoleLoginRequest request) {
        Long account = Long.valueOf(request.getAccount());
        String password = request.getPassword();
        UserBO userBO = userReadService.login(account, password);
        ConsoleLoginDTO loginDTO = new ConsoleLoginDTO();
        if (Objects.nonNull(userBO) && userBO.getPassword().equals(password)) {
            String token = UUID.randomUUID().toString();
            redisUtil.set(token, account);
            loginDTO.setToken(token);
            return ResponseFactory.success(loginDTO, ConsoleLoginResponse.class);
        }
        return ResponseFactory.fail(ACCOUNT_OR_PASSWORD_INVALID, ConsoleLoginResponse.class);
    }

    @PostMapping("/getUserContext")
    public ConsoleGetUserContextResponse getUserContext(@RequestBody ConsoleGetUserContextRequest request) {
        UserBO userContext = userReadService.getUserContext(request.getAccount());
        return ResponseFactory.success(GetUserContextDTOConvert.toGetUserContextDTO(userContext),
                        ConsoleGetUserContextResponse.class);
    }
}
