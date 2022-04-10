package com.example.myblog.model.request.user;

import com.example.myblog.model.request.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ConsoleLoginRequest extends BaseRequest {
    @NotBlank
    private String account;
    @NotBlank
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConsoleLoginRequest{" + "account='" + account + '\'' + ", password='" + password + '\'' + '}';
    }
}
