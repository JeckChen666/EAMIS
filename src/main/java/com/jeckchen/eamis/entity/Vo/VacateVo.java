package com.jeckchen.eamis.entity.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

/**
 * @author chenj
 * @version 1.0.0
 * @className VacateVo.java
 * @description jc
 * @date 2022年06月14日 11:12
 */
@Data
public class VacateVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String reason;

    private Date startTime;

    private Date endTime;

    private Double state;
}
