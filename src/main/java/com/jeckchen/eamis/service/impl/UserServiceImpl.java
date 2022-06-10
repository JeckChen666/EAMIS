package com.jeckchen.eamis.service.impl;

import com.jeckchen.eamis.common.Result;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.Vo.LoginVo;
import com.jeckchen.eamis.mapper.UserMapper;
import com.jeckchen.eamis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginVo loginVo) {
        User user = null;
        user = userMapper.getUserByPhone(loginVo.getPhone());
        if (user!=null){
            if (loginVo.getPassword().equals(user.getPassword())){
                Session.getSession().put(SessionType.USER.toString(), user);
                return Result.ok();
            }else {
                return Result.error("密码错误");
            }
        }
        return Result.error("用户不存在");
    }
}
