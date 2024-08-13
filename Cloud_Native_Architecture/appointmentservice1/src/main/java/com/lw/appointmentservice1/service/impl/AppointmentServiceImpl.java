package com.lw.appointmentservice1.service.impl;


import com.lw.appointmentservice1.dao.AppointmentDao;
import com.lw.appointmentservice1.entity.Appointment;
import com.lw.appointmentservice1.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.ArrayList;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentDao appointmentDao;

    /**
     * 通过 appointmentId 查询单条数据
     *
     * @param appointmentId 主键
     * @return 实例对象
     */
    @Override
    public Appointment queryById(String appointmentId) {
        return this.appointmentDao.queryById(appointmentId);
    }

    /**
     * 分页查询
     *
     * @param appointment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Appointment> queryByPage(Appointment appointment, PageRequest pageRequest) {
        long total = this.appointmentDao.count(appointment);
        return new PageImpl<>(this.appointmentDao.queryAllByLimit(appointment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public Appointment insert(Appointment appointment) {
        this.appointmentDao.insert(appointment);
        return appointment;
    }

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public Appointment update(Appointment appointment) {
        this.appointmentDao.update(appointment);
        return this.queryById(appointment.getAppointmentId());
    }

    /**
     * 通过 appointmentId 删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String appointmentId) {
        return this.appointmentDao.deleteById(appointmentId) > 0;
    }

    /**
     * 查找所有appointment数据，返回List集合
     *
     * @return 所有appointment数据
     */
    @Override
    public ArrayList<Appointment> queryAll() {
        return this.appointmentDao.queryAll();
    }
}

