package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.BusinessTrip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 出差表 Mapper 接口
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Mapper
public interface BusinessTripMapper extends BaseMapper<BusinessTrip> {
    @Update("UPDATE TB_BUSINESSTRIP SET END_TIME=(SELECT START_TIME+trunc(dbms_random.value(1,100),3) FROM TB_BUSINESSTRIP,dual WHERE ID=#{id}) WHERE ID=#{id}")
    Integer updateEndTime(String id);

    @Update("UPDATE TB_BUSINESSTRIP SET STATE=#{state} WHERE ID=#{id}")
    Integer updateState(String id,String state);
}
