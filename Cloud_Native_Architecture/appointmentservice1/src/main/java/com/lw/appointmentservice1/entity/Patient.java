package com.lw.appointmentservice1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Patient)实体类
 *
 * @author makejava
 * @since 2024-07-11 05:28:31
 */
@Data
public class Patient implements Serializable {
    private static final long serialVersionUID = -96745475723364387L;
    private String patientId;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private Date birthDate;
    private String gender;
    private String address;
    private String occupation;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String primaryPhysician;
    private String insuranceProvider;
    private String insurancePolicyNumber;
    private String allergies;
    private String currentMedication;
    private String familyMedicalHistory;
    private String pastMedicalHistory;
    private Integer privacyConsent;


}

