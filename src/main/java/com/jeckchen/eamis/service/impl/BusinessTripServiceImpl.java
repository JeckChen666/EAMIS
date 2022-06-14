package com.jeckchen.eamis.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.entity.BusinessTrip;
import com.jeckchen.eamis.entity.Vo.BusinessTripVo;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.jeckchen.eamis.mapper.BusinessTripMapper;
import com.jeckchen.eamis.service.BusinessTripService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 出差表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class BusinessTripServiceImpl extends ServiceImpl<BusinessTripMapper, BusinessTrip> implements BusinessTripService {

    @Autowired
    private BusinessTripMapper businessTripMapper;

    @Override
    public List<BusinessTripVo> getBusinessTripList(String id){
        Date lastYearDate = DateUtil.offset(DateUtil.date(), DateField.YEAR, -5);
        String formatDate = DateUtil.format(lastYearDate, "yyyy-MM-dd HH:mm:ss");
        List<BusinessTripVo> list = businessTripMapper.getList(id, formatDate);
        return list;
    }

    @Override
    public Boolean logicalEnd(String id) {
        BusinessTrip businessTrip = this.getById(id);
        businessTrip.setState(3.0);
        boolean update = this.updateById(businessTrip);
        return update;
    }

    @Override
    public Boolean logicalStart(String id) {
        BusinessTrip businessTrip = this.getById(id);
        businessTrip.setState(2.0);
        boolean update = this.updateById(businessTrip);
        return update;
    }

    @Override
    public Boolean logicalRemove(String id) {
        BusinessTrip businessTrip = this.getById(id);
        businessTrip.setState(0.0);
        boolean update = this.updateById(businessTrip);
        return update;
    }
}
