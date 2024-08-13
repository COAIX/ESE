package com.lw.patientservice1.service;



import com.lw.patientservice1.entity.Patient;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;


/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
public interface PatientService {

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    Patient queryById(String patientId);

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Patient> queryByPage(Patient patient, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient insert(Patient patient);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient update(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    boolean deleteById(String patientId);

    /**
     * 通过userId查询单个Patient
     *
     * @param userId
     * @return
     */
    Patient queryByUserId(String userId);

    Patient updateByUserId(Patient patient);
}
