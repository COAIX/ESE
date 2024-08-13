package com.lw.appointmentservice1.controller;


import com.lw.appointmentservice1.entity.Appointment;
import com.lw.appointmentservice1.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.util.ArrayList;

/**
 * (Appointment)表控制层
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@RestController
@RequestMapping("appointment")
public class AppointmentController {
    /**
     * 服务对象
     */
    @Resource
    private AppointmentService appointmentService;

    /**
     * 分页查询
     *
     * @param appointment 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Appointment>> queryByPage(Appointment appointment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.appointmentService.queryByPage(appointment, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param appointmentId 主键
     * @return 单条数据
     */
    @GetMapping("{appointmentId}")
    public ResponseEntity<Appointment> queryById(@PathVariable("appointmentId") String appointmentId) {
        return ResponseEntity.ok(this.appointmentService.queryById(appointmentId));
    }

    /**
     * 查找所有appointment数据，返回List集合
     *
     * @return 所有appointment数据
     */
    @GetMapping("all")
    public ResponseEntity<ArrayList<Appointment>> queryAll() {
        return ResponseEntity.ok(this.appointmentService.queryAll());
    }

    /**
     * 新增数据
     *
     * @param appointment 实体
     * @return 新增结果
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
     * 编辑数据
     *
     * @param appointment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Appointment> edit(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(this.appointmentService.update(appointment));
    }

    /**
     * 删除数据
     *
     * @param appointmentId 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String appointmentId) {
        return ResponseEntity.ok(this.appointmentService.deleteById(appointmentId));
    }

}

