package com.example.myblog.model.dto.user;


public class ConsoleGetUserContextDTO {

    private GetUserContextDTO content;

    public GetUserContextDTO getContent() {
        return content;
    }

    public void setContent(GetUserContextDTO content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ConsoleGetUserContextDTO{" + "content=" + content + '}';
    }
}
