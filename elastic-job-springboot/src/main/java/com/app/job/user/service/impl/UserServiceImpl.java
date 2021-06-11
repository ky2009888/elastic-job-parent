package com.app.job.user.service.impl;

import com.app.job.user.entity.User;
import com.app.job.user.mapper.UserMapper;
import com.app.job.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author elastic-job
 * @since 2021-06-11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
