package com.jeckchen.eamis.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeckchen.eamis.entity.Attendance;
import com.jeckchen.eamis.entity.Vo.AttendanceVo;
import com.jeckchen.eamis.mapper.AttendanceMapper;
import com.jeckchen.eamis.service.AttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public Boolean isClockIn(String userId) {
        QueryWrapper<Attendance> queryWrapper=new QueryWrapper<>();
        Date beginOfDay = DateUtil.beginOfDay(DateUtil.date());
        Date endOfDay = DateUtil.endOfDay(DateUtil.date());
        queryWrapper.apply("CREATE_TIME >= to_date('" + beginOfDay + "','yyyy-MM-dd HH24:MI:SS')"+" AND "+"CREATE_TIME <= to_date('" + endOfDay + "','yyyy-MM-dd HH24:MI:SS')"+" AND "+"USER_ID = "+userId);
        int count = this.count(queryWrapper);
        return count != 0;
    }

    @Transactional
    @Override
    public Boolean clockIn(String userId) {
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);

        int state=1;
        Date beginOfDay = DateUtil.beginOfDay(DateUtil.date());
        Date now = DateUtil.date();
        Date lateTime = DateUtil.offset(beginOfDay, DateField.HOUR, 12);
        Date earlyTime = DateUtil.offset(beginOfDay, DateField.HOUR, 9);

        if (now.after(lateTime)){
            state=2;
        }else if (now.before(earlyTime)){
            state=0;
        }
        attendance.setState((double) state);
        attendance.setCreateTime(now);

        return this.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(String userId) {
        QueryWrapper<Attendance> queryWrapper=new QueryWrapper<>();
        Date beginOfDay = DateUtil.beginOfDay(DateUtil.date());
        Date endOfDay = DateUtil.endOfDay(DateUtil.date());
        queryWrapper.apply("CREATE_TIME >= to_date('" + beginOfDay + "','yyyy-MM-dd HH24:MI:SS')"+" AND "+"CREATE_TIME <= to_date('" + endOfDay + "','yyyy-MM-dd HH24:MI:SS')"+" AND "+"USER_ID = "+userId);
        return this.getOne(queryWrapper);
    }


    @Override
    public List<AttendanceVo> getAttendanceList(String id) {
        Date lastYearDate = DateUtil.offset(DateUtil.date(), DateField.YEAR, -5);
        String formatDate = DateUtil.format(lastYearDate, "yyyy-MM-dd HH:mm:ss");
        List<AttendanceVo> list = attendanceMapper.getList(id, formatDate);
        return list;
    }
}
