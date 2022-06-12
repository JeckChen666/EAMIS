package com.jeckchen.eamis.mapper;

import com.jeckchen.eamis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select ID,USERNAME,PASSWORD,PHONE,SEX,BIRTHDAY,JOB,ENTRYTIME,STATE from TB_USER where STATE in (1,2) and PHONE=#{phone}")
    User getUserByPhone(String phone);
}
