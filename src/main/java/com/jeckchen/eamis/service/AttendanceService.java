package com.jeckchen.eamis.service;

import com.jeckchen.eamis.entity.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeckchen.eamis.entity.Vo.AttendanceVo;

import java.util.List;

/**
 * <p>
 * 出勤表 服务类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */

public interface AttendanceService extends IService<Attendance> {
    Boolean isClockIn(String userId);
    Boolean clockIn(String userId);
    Attendance getAttendanceById(String userId);

    List<AttendanceVo> getAttendanceList(String id);
}
