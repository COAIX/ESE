package com.lw.g_healthcare.service;


import com.lw.g_healthcare.entity.Patient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;


/**
 * (Patient) Patient Service
 * Interface
 */
public interface PatientService {

     /**
     * Query a single data by primary key
     *
     * @param patientId  primary key
     * @return query result
     */
    Patient queryById(String patientId);

    /**
     * Paging query
     *
     * @param patient     filter condition
     * @param pageRequest paging object
     * @return query result
     */
    Page<Patient> queryByPage(Patient patient, PageRequest pageRequest);

    /**
     * Add data
     *
     * @param patient  instance object
     */
    Patient insert(Patient patient);

    /**
     * Modify data
     *
     * @param patient  instance object
     */
    Patient update(Patient patient);

    /**
     * Delete data by primary key
     *
     * @param patientId  primary key
     */
    boolean deleteById(String patientId);

    /**
     * Query all data
     */
    Patient queryByUserId(String userId);

    /**
     * Modify data
     *
     * @param patient  instance object
     */
    Patient updateByUserId(Patient patient);
}
