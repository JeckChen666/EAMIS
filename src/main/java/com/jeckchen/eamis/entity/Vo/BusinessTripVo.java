package com.jeckchen.eamis.entity.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Clob;
import java.util.Date;

/**
 * @author chenj
 * @version 1.0.0
 * @className BusinessTripVo.java
 * @description jc
 * @date 2022年06月14日 17:16
 */
@Data
public class BusinessTripVo {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String reason;

    private String location;

    private Double cost;

    private Date startTime;

    private Date endTime;

    private Double state;

}
