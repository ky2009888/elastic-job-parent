package com.app.job.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author elastic-job
 * @since 2021-06-11
 */
@Data
@EqualsAndHashCode()
public class User implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;
    /**
     * 主键id.
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * age
     */
    private Integer age;

    /**
     * 邮件
     */
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
