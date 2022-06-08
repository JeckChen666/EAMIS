package com.jeckchen.eamis.entity.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenj
 * @version 1.0.0
 * @className LoginVo.java
 * @description jc
 * @date 2022年06月06日 20:39
 */
@Data
public class LoginVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phone;

    private String password;

}
