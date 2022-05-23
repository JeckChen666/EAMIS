package com.jeckchen.eamis.service.impl;

import com.jeckchen.eamis.entity.TripUser;
import com.jeckchen.eamis.mapper.TripUserMapper;
import com.jeckchen.eamis.service.TripUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加班_用户_关系表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class TripUserServiceImpl extends ServiceImpl<TripUserMapper, TripUser> implements TripUserService {

}
