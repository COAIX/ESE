package com.lw.patientservice1.controller;


import com.lw.patientservice1.entity.Patient;
import com.lw.patientservice1.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;


/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@RestController
@RequestMapping("patient")
public class PatientController {
    /**
     * 服务对象
     */
    @Resource
    private PatientService patientService;

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Patient>> queryByPage(Patient patient, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientService.queryByPage(patient, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param patientId 主键
     * @return 单条数据
     */
    @GetMapping("{patientId}")
    public ResponseEntity<Patient> queryById(@PathVariable("patientId") String patientId) {
        return ResponseEntity.ok(this.patientService.queryById(patientId));
    }

    /**
     * 通过userId查询单个Patient
     *
     * @param userId
     * @return 单条数据
     */
    @GetMapping("userId/{userId}")
    public ResponseEntity<Patient> queryByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(this.patientService.queryByUserId(userId));
    }

    /**
     * 新增数据
     *
     * @param patient 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        if (patient.getPatientId().isEmpty()) {
            System.out.println("patientId is empty");
            return ResponseEntity.ok(null);
        }
        try {
            return ResponseEntity.ok(this.patientService.insert(patient));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok(null);
        }
    }

    /**
     * 编辑数据
     *
     * @param patient 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Patient> edit(@RequestBody Patient patient) {
        return ResponseEntity.ok(this.patientService.update(patient));
    }

    /**
     * 通过userId修改数据
     *
     * @param patient 实体
     * @return 编辑结果
     */
    @PutMapping("userId")
    public ResponseEntity<Patient> editByUserId(@RequestBody Patient patient) {
        return ResponseEntity.ok(this.patientService.updateByUserId(patient));
    }

    /**
     * 删除数据
     *
     * @param patientId 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String patientId) {
        return ResponseEntity.ok(this.patientService.deleteById(patientId));
    }

}

