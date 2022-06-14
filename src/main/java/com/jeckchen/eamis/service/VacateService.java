package com.jeckchen.eamis.service;

import com.jeckchen.eamis.entity.Vacate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeckchen.eamis.entity.Vo.VacateVo;

import java.util.List;

/**
 * <p>
 * 请销假表 服务类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
public interface VacateService extends IService<Vacate> {
    List<VacateVo> getVacateList(String id);
    Boolean logicalRemove(String id);
    Boolean logicalStart(String id);
    Boolean logicalEnd(String id);
}
