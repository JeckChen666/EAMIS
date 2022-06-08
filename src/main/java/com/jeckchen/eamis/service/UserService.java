package com.jeckchen.eamis.service;

import com.jeckchen.eamis.common.Result;
import com.jeckchen.eamis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeckchen.eamis.entity.Vo.LoginVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
public interface UserService extends IService<User> {
    Result login(LoginVo loginVo);
}
