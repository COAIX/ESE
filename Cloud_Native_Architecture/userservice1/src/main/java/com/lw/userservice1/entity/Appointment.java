package com.lw.userservice1.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Appointment)实体类
 *
 * @author makejava
 * @since 2024-07-11 05:28:31
 */
@Data
public class Appointment implements Serializable {
    private static final long serialVersionUID = 757244483895397462L;
    private String appointmentId;
    private String userId;
    private String patient;
    private String primaryPhysician;
    private String reason;
    private Date schedule;
    private String status;
    private String note;


}

