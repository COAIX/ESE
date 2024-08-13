package com.lw.g_healthcare.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Appointment) Appointment Entity
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

