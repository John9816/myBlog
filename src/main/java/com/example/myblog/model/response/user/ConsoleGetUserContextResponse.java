package com.example.myblog.model.response.user;

import com.example.myblog.model.dto.user.GetUserContextDTO;
import com.example.myblog.model.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConsoleGetUserContextResponse extends BaseResponse {
    /**
     * 用户上下文
     */
    private GetUserContextDTO content;
}
