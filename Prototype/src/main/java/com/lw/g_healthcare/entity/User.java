package com.lw.g_healthcare.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User) User Entity
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -97460551375145554L;
    private String userId;
    private String email;
    private String phone;
    private String name;


}

