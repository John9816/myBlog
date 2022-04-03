package com.example.myblog.model.request.user;

import com.example.myblog.model.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ConsoleGetUserContextRequest extends BaseRequest {

    /**
     * 账户
     */
    @Positive
    @NotNull
    private Long account;

}
