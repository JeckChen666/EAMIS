package com.jeckchen.eamis.service.impl;

import com.jeckchen.eamis.entity.Attendance;
import com.jeckchen.eamis.mapper.AttendanceMapper;
import com.jeckchen.eamis.service.AttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 出勤表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

}
