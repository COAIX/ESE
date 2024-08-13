package com.lw.appointmentservice1.service;

import com.lw.appointmentservice1.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.ArrayList;

/**
 * (Appointment)表服务接口
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
public interface AppointmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param appointmentId 主键
     * @return 实例对象
     */
    Appointment queryById(String appointmentId);

    /**
     * 分页查询
     *
     * @param appointment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Appointment> queryByPage(Appointment appointment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment insert(Appointment appointment);

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment update(Appointment appointment);

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    boolean deleteById(String appointmentId);

    ArrayList<Appointment> queryAll();
}
