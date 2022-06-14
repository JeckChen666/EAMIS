package com.jeckchen.eamis.service;

import com.jeckchen.eamis.entity.BusinessTrip;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeckchen.eamis.entity.Vo.BusinessTripVo;

import java.util.List;

/**
 * <p>
 * 出差表 服务类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
public interface BusinessTripService extends IService<BusinessTrip> {
    List<BusinessTripVo> getBusinessTripList(String id);
    Boolean logicalEnd(String id);
    Boolean logicalStart(String id);
    Boolean logicalRemove(String id);

}
