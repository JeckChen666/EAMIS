package com.jeckchen.eamis.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.entity.Vacate;
import com.jeckchen.eamis.entity.Vo.VacateVo;
import com.jeckchen.eamis.mapper.VacateMapper;
import com.jeckchen.eamis.service.VacateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 请销假表 服务实现类
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Service
public class VacateServiceImpl extends ServiceImpl<VacateMapper, Vacate> implements VacateService {

    @Autowired
    private VacateMapper vacateMapper;

    @Override
    public List<VacateVo> getVacateList(String id) {
        Date lastYearDate = DateUtil.offset(DateUtil.date(), DateField.YEAR, -5);
        String formatDate = DateUtil.format(lastYearDate, "yyyy-MM-dd HH:mm:ss");
//        System.out.println("formatDate"+formatDate);
        List<VacateVo> vacateList = vacateMapper.getList(id, formatDate);
        return vacateList;
    }

    @Override
    public Boolean logicalRemove(String id) {
        Vacate vacate = this.getById(id);
        vacate.setState(0.0);
        boolean update = this.updateById(vacate);
        return update;
    }

    @Override
    public Boolean logicalStart(String id) {
        Vacate vacate = this.getById(id);
        vacate.setState(2.0);
        boolean update = this.updateById(vacate);
        return update;
    }

    @Override
    public Boolean logicalEnd(String id) {
        Vacate vacate = this.getById(id);
        vacate.setState(3.0);
        boolean update = this.updateById(vacate);
        return update;
    }
}
