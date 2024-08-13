package com.lw.appointmentservice1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-07-11 05:28:31
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -97460551375145554L;
    private String userId;
    private String email;
    private String phone;
    private String name;


}

