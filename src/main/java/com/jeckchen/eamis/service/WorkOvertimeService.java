package com.jeckchen.eamis.service;

import com.jeckchen.eamis.entity.Vo.WorkOvertimeVo;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 加班表 服务类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
public interface WorkOvertimeService extends IService<WorkOvertime> {
    List<WorkOvertimeVo> getWorkOvertimeList(String id);

    Boolean logicalEnd(String id);

    Boolean logicalStart(String id);

    Boolean logicalRemove(String id);
}
