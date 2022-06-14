package com.jeckchen.eamis.entity.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenj
 * @version 1.0.0
 * @className AttendanceVo.java
 * @description jc
 * @date 2022年06月14日 20:55
 */
@Data
public class AttendanceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private Double state;

    private Date createTime;
}
