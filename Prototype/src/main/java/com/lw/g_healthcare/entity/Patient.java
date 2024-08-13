package com.lw.g_healthcare.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Patient) Patient Entity
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

