package com.glodon.rulelib.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LC
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppUser extends Model<AppUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "app_user_id", type = IdType.AUTO)
    private Integer appUserId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像url
     */
    @TableField("headImgUrl")
    private String headImgUrl;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 状态（1有效,0无效）
     */
    private Boolean enabled;

    /**
     * 类型（暂未用）
     */
    private String type;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.appUserId;
    }

}
