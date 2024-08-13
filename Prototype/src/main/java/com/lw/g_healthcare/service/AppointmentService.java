package com.lw.g_healthcare.service;

import com.lw.g_healthcare.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;

/**
 * (Appointment) Appointment Service
 * Interface
 */
public interface AppointmentService {

    /**
     * Query a single data by primary key
     *
     * @param appointmentId  primary key
     */
    Appointment queryById(String appointmentId);

    /**
     * Paging query
     *
     * @param appointment  filter condition
     * @param pageRequest  paging object
     */
    Page<Appointment> queryByPage(Appointment appointment, PageRequest pageRequest);

    /**
     * Add data
     *
     * @param appointment  instance object
     */
    Appointment insert(Appointment appointment);

    /**
     * Modify data
     *
     * @param appointment  instance object
     */
    Appointment update(Appointment appointment);

    /**
     * Delete data by primary key
     *
     * @param appointmentId  primary key
     */
    boolean deleteById(String appointmentId);

    /**
     * Query all data
     */
    ArrayList<Appointment> queryAll();
}
