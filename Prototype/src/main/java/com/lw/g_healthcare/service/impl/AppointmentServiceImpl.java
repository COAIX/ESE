package com.lw.g_healthcare.service.impl;

import com.lw.g_healthcare.entity.Appointment;
import com.lw.g_healthcare.dao.AppointmentDao;
import com.lw.g_healthcare.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import jakarta.annotation.Resource;

import java.util.ArrayList;

/**
 * (Appointment) Appointment Service
 * Implementation
 */
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    /**
     * Service object
     */
    @Resource
    private AppointmentDao appointmentDao;

    /**
     * Query a single data by primary key
     *
     * @param appointmentId  primary key
     */
    @Override
    public Appointment queryById(String appointmentId) {
        return this.appointmentDao.queryById(appointmentId);
    }

    /**
     * Paging query
     *
     * @param appointment  filter condition
     * @param pageRequest  paging object
     */
    @Override
    public Page<Appointment> queryByPage(Appointment appointment, PageRequest pageRequest) {
        long total = this.appointmentDao.count(appointment);
        return new PageImpl<>(this.appointmentDao.queryAllByLimit(appointment, pageRequest), pageRequest, total);
    }

    /**
     * Add data
     *
     * @param appointment  instance object
     */
    @Override
    public Appointment insert(Appointment appointment) {
        this.appointmentDao.insert(appointment);
        return appointment;
    }

    /**
     * Modify data
     *
     * @param appointment  instance object
     */
    @Override
    public Appointment update(Appointment appointment) {
        this.appointmentDao.update(appointment);
        return this.queryById(appointment.getAppointmentId());
    }

    /**
     * Delete data by primary key
     *
     * @param appointmentId  primary key
     */
    @Override
    public boolean deleteById(String appointmentId) {
        return this.appointmentDao.deleteById(appointmentId) > 0;
    }

    /**
     * Query all data
     */
    @Override
    public ArrayList<Appointment> queryAll() {
        return this.appointmentDao.queryAll();
    }
}

