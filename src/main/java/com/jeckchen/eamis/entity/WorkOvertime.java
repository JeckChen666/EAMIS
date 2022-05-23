package com.jeckchen.eamis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 加班表
 * </p>
 *
 * @author chenjie
 * @since 2022-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TB_WORKOVERTIME")
public class WorkOvertime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("USER_ID")
    private String userId;

    @TableField("REASON")
    private String reason;

    @TableField("START_TIME")
    private Date startTime;

    @TableField("END_TIME")
    private Date endTime;

    @TableField("STATE")
    private Double state;

    @TableField("CREATE_TIME")
    private Date createTime;


}
