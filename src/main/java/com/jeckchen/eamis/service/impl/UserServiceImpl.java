package com.jeckchen.eamis.service.impl;

import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.mapper.UserMapper;
import com.jeckchen.eamis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
