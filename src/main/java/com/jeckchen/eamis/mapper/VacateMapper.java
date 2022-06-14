package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.Vacate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeckchen.eamis.entity.Vo.VacateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    @Select("select TV.ID AS ID,\n" +
            "               TU.USERNAME AS USERNAME,\n" +
            "               TV.REASON AS REASON,\n" +
            "               TV.START_TIME AS START_TIME,\n" +
            "               TV.END_TIME AS END_TIME,\n" +
            "               TV.STATE AS STATE\n" +
            "        from TB_VACATE TV left join TB_USER TU on TU.ID = TV.USER_ID\n" +
            "        where TV.START_TIME >= to_date(#{startTime},'yyyy-MM-dd HH24:MI:SS') AND TU.ID=#{userId}")
    List<VacateVo> getList(@Param("userId")String userId, @Param("startTime")String startTime);

}
