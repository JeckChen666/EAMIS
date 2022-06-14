package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.Vo.VacateVo;
import com.jeckchen.eamis.entity.Vo.WorkOvertimeVo;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    @Select("select TW.ID AS id,\n" +
            "       TU.USERNAME AS username,\n" +
            "       TW.REASON AS reason,\n" +
            "       TW.START_TIME AS start_time,\n" +
            "       TW.END_TIME AS end_time,\n" +
            "       TW.STATE AS state\n" +
            "from TB_WORKOVERTIME TW left join TB_USER TU on TU.ID = TW.USER_ID\n" +
            "where TW.START_TIME >= to_date(#{startTime},'yyyy-MM-dd HH24:MI:SS') and TU.ID=#{userId} order by START_TIME desc")
    List<WorkOvertimeVo> getList(@Param("userId")String userId, @Param("startTime")String startTime);
}
