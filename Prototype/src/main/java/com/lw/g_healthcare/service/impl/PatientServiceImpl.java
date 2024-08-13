package com.lw.g_healthcare.service.impl;

import org.springframework.data.domain.Page;

import com.lw.g_healthcare.dao.PatientDao;
import com.lw.g_healthcare.entity.Patient;
import com.lw.g_healthcare.service.PatientService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * (Patient) Service Implementation
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {

    /**
     * Service object
     */
    @Resource
    private PatientDao patientDao;

    /**
     * Query a single data by primary key
     *
     * @param patientId primary key
     * @return query result
     */
    @Override
    public Patient queryById(String patientId) {
        return this.patientDao.queryById(patientId);
    }

    /**
     * Paging query
     *
     * @param patient     filter condition
     * @param pageRequest paging object
     * @return query result
     */
    @Override
    public Page<Patient> queryByPage(Patient patient, PageRequest pageRequest) {
        long total = this.patientDao.count(patient);
        return new PageImpl<>(this.patientDao.queryAllByLimit(patient, pageRequest), pageRequest, total);
    }

    /**
     * Add data
     *
     * @param patient instance object
     * @return
     */
    @Override
    public Patient insert(Patient patient) {
        this.patientDao.insert(patient);
        return patient;
    }

    /**
     * Modify data
     *
     * @param patient instance object
     * @return
     */
    @Override
    public Patient update(Patient patient) {
        this.patientDao.update(patient);
        return this.queryById(patient.getPatientId());
    }

    /**
     * Delete data by primary key
     *
     * @param patientId primary key
     * @return
     */
    @Override
    public boolean deleteById(String patientId) {
        return this.patientDao.deleteById(patientId) > 0;
    }

    /**
     * Query all data
     *
     * @return
     */
    @Override
    public Patient queryByUserId(String userId) {
        Patient patient = this.patientDao.queryByUserId(userId);
//        if (patient.getAddress()==null || patient.getAddress().isEmpty()){
//            return null;
//        }
        return patient;
    }

    /**
     * Update data by userId
     *
     * @param patient instance object
     * @return
     */
    @Override
    public Patient updateByUserId(Patient patient) {
        int i = this.patientDao.updateByUserId(patient);
        if (i>0){
            return patient;
        }
        return null;
    }
}

