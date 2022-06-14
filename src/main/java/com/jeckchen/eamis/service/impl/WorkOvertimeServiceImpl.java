package com.jeckchen.eamis.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.entity.Vo.WorkOvertimeVo;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.jeckchen.eamis.mapper.WorkOvertimeMapper;
import com.jeckchen.eamis.service.WorkOvertimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 加班表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class WorkOvertimeServiceImpl extends ServiceImpl<WorkOvertimeMapper, WorkOvertime> implements WorkOvertimeService {

    @Autowired
    private WorkOvertimeMapper workOvertimeMapper;


    @Override
    public List<WorkOvertimeVo> getWorkOvertimeList(String id) {
        Date lastYearDate = DateUtil.offset(DateUtil.date(), DateField.YEAR, -5);
        String formatDate = DateUtil.format(lastYearDate, "yyyy-MM-dd HH:mm:ss");
        List<WorkOvertimeVo> overtimeMapperList = workOvertimeMapper.getList(id, formatDate);
        return overtimeMapperList;
    }

    @Override
    public Boolean logicalEnd(String id) {
        WorkOvertime workOvertime = this.getById(id);
        workOvertime.setState(2.0);
        boolean update = this.updateById(workOvertime);
        return update;
    }

    @Override
    public Boolean logicalStart(String id) {
        WorkOvertime workOvertime = this.getById(id);
        workOvertime.setState(1.0);
        boolean update = this.updateById(workOvertime);
        return update;
    }

    @Override
    public Boolean logicalRemove(String id) {
        WorkOvertime workOvertime = this.getById(id);
        workOvertime.setState(0.0);
        boolean update = this.updateById(workOvertime);
        return update;
    }
}
