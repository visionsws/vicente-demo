package com.vicente.vicentedemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author weisen
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 软删除标识，Y/N
     */
    private String valid;

    /**
     * 限制允许登录的IP集合
     */
    private String limitedIp;

    /**
     * 账号失效时间，超过时间将不能登录系统
     */
    private LocalDateTime expiredTime;

    /**
     * 最近修改密码时间，超出时间间隔，提示用户修改密码
     */
    private LocalDateTime lastChangePwdTime;

    /**
     * 是否允许账号同一个时刻多人在线，Y/N
     */
    private String limitMultiLogin;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
