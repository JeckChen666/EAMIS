package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.WorkOvertime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 加班表 Mapper 接口
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Mapper
public interface WorkOvertimeMapper extends BaseMapper<WorkOvertime> {
    @Update("UPDATE TB_WORKOVERTIME SET END_TIME=(SELECT START_TIME+trunc(dbms_random.value(0,1),3) FROM TB_WORKOVERTIME,dual WHERE ID=#{id}) WHERE ID=#{id}")
    Integer updateEndTime(String id);
}
