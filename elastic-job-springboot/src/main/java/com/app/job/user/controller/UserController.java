package com.app.job.user.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.job.user.entity.User;
import com.app.job.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author elastic-job
 * @since 2021-06-11
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 定义用户服务句柄.
     */
    @Resource
    private IUserService userService;

    /**
     * 根据主键查询用户.
     *
     * @param id 用户id.
     * @return JSONObject.
     */
    @GetMapping("find")
    @ResponseBody
    public String showUser(long id) {
        User user = userService.getById(id);
        return user.toString();
    }
}
