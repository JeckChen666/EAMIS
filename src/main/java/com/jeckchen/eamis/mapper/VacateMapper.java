package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.Vacate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 请销假表 Mapper 接口
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Mapper
public interface VacateMapper extends BaseMapper<Vacate> {
    @Update("UPDATE TB_VACATE SET END_TIME=(SELECT START_TIME+trunc(dbms_random.value(1,30),3) FROM TB_VACATE,dual WHERE ID=#{id}) WHERE ID=#{id}")
    Integer updateEndTime(String id);

}
