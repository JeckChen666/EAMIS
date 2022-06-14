package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.BusinessTrip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeckchen.eamis.entity.Vo.BusinessTripVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    @Select("select TB.ID as id, TU.USERNAME as username, TB.REASON as reason, TB.LOCATION as location, TB.COST as cost, TB.START_TIME as start_time, TB.END_TIME as end_time, TB.STATE as state\n" +
            "    from TB_BUSINESSTRIP TB\n" +
            "    left join TB_TRIP_USER TTU on TB.ID = TTU.TRIP_ID\n" +
            "    left join TB_USER TU on TU.ID = TTU.USER_ID\n" +
            "    where TB.START_TIME >= to_date(#{startTime},'yyyy-MM-dd HH24:MI:SS') and TU.ID=#{userId} order by START_TIME desc")
    List<BusinessTripVo> getList(@Param("userId")String userId, @Param("startTime")String startTime);
}
