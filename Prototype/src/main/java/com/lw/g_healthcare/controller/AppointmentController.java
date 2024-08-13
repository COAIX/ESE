package com.lw.g_healthcare.controller;

import com.lw.g_healthcare.entity.Appointment;
import com.lw.g_healthcare.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.util.ArrayList;

/**
 * (Appointment) Appointment Controller
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@RestController
@RequestMapping("appointment")
public class AppointmentController {
    /**
     * Service object
     */
    @Resource
    private AppointmentService appointmentService;

    /**
     * Paging query
     *
     * @param appointment  filter condition
     * @param pageRequest  paging object
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Appointment>> queryByPage(Appointment appointment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.appointmentService.queryByPage(appointment, pageRequest));
    }

    /**
     * Query a single data by primary key
     *
     * @param appointmentId  primary key
     * @return  single data
     */
    @GetMapping("{appointmentId}")
    public ResponseEntity<Appointment> queryById(@PathVariable("appointmentId") String appointmentId) {
        return ResponseEntity.ok(this.appointmentService.queryById(appointmentId));
    }

    /**
     * Query all data
     *
     * @return
     */
    @GetMapping("all")
    public ResponseEntity<ArrayList<Appointment>> queryAll() {
        return ResponseEntity.ok(this.appointmentService.queryAll());
    }

    /**
     * Add data
     *
     * @param appointment  entity
     * @return  entity
     */
    @PostMapping
    public ResponseEntity<Appointment> add(@RequestBody Appointment appointment) {
        if (appointment.getAppointmentId().isEmpty()) {
            System.out.println("appointmentId is empty");
            return ResponseEntity.ok(null);
        }
        try {
            return ResponseEntity.ok(this.appointmentService.insert(appointment));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok(null);
        }
    }

    /**
     * Edit data
     *
     * @param appointment  entity
     * @return  entity
     */
    @PutMapping
    public ResponseEntity<Appointment> edit(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(this.appointmentService.update(appointment));
    }

    /**
     * Delete data by appointmentId
     *
     * @param appointmentId  primary key
     * @return  success or not
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String appointmentId) {
        return ResponseEntity.ok(this.appointmentService.deleteById(appointmentId));
    }

}

