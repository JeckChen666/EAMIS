package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.Attendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeckchen.eamis.entity.Vo.AttendanceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 出勤表 Mapper 接口
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {

    @Select("select TA.ID as id, TU.USERNAME as username, TA.STATE as state, TA.CREATE_TIME as create_time\n" +
            "from TB_ATTENDANCE TA left join TB_USER TU on TU.ID = TA.USER_ID\n" +
            "where TA.CREATE_TIME >= to_date(#{startTime}, 'yyyy-MM-dd HH24:MI:SS') and TU.ID=#{userId} order by TA.CREATE_TIME desc")
    List<AttendanceVo> getList(@Param("userId")String userId, @Param("startTime")String startTime);
}
