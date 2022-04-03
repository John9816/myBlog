package com.example.myblog.model.bo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserBO extends BaseBO{
    /**
     * 昵称
     */
    private String  nickName;
    /**
     * 账户
     */
    private Long    account;
    /**
     * 密码
     */
    private String  password;
    /**
     * 性别
     */
    private Integer  gender;
    /**
     * 头像
     */
    private String  avatar;
    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 用于解决Lombok的Builder无法Build父类属性问题
     */
    @Builder(builderMethodName = "childBuilder")
    public UserBO(Long id, Date createdTime, Date updatedTime, String nickName, Long account, String password,
                  Integer gender, String avatar, Integer isDeleted) {
        super(id, createdTime, updatedTime);
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.gender = gender;
        this.avatar = avatar;
        this.isDeleted = isDeleted;
    }
}
