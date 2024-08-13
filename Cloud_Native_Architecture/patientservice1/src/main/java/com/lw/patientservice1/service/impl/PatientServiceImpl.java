package com.lw.patientservice1.service.impl;



import com.lw.patientservice1.dao.PatientDao;
import com.lw.patientservice1.entity.Patient;
import com.lw.patientservice1.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import jakarta.annotation.Resource;



/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    @Resource
    private PatientDao patientDao;

    /**
     * 通过 patientId 查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    @Override
    public Patient queryById(String patientId) {
        return this.patientDao.queryById(patientId);
    }

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Patient> queryByPage(Patient patient, PageRequest pageRequest) {
        long total = this.patientDao.count(patient);
        return new PageImpl<>(this.patientDao.queryAllByLimit(patient, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @Override
    public Patient insert(Patient patient) {
        this.patientDao.insert(patient);
        return patient;
    }

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @Override
    public Patient update(Patient patient) {
        this.patientDao.update(patient);
        return this.queryById(patient.getPatientId());
    }

    /**
     * 通过 patientId 删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String patientId) {
        return this.patientDao.deleteById(patientId) > 0;
    }

    /**
     * 通过userId查询单个Patient
     *
     * @param userId
     * @return
     */
    @Override
    public Patient queryByUserId(String userId) {
        Patient patient = this.patientDao.queryByUserId(userId);
        if (patient.getAddress()==null || patient.getAddress().isEmpty()){
            return null;
        }
        return patient;
    }

    /**
     * 通过userId更新Patient
     *
     * @param patient
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

