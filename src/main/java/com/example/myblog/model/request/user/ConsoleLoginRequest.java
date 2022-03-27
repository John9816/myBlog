package com.example.myblog.model.request.user;

import com.example.myblog.model.request.BaseRequest;
import lombok.Data;

@Data
public class ConsoleLoginRequest extends BaseRequest {
    private String username;
    private String password;
}
