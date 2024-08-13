package com.lw.patientservice1.dao;

import com.lw.patientservice1.entity.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Patient)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
public interface PatientDao {

    /**
     * 通过 patientId 查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    Patient queryById(String patientId);

    /**
     * 查询指定行数据
     *
     * @param patient 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Patient> queryAllByLimit(Patient patient, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patient 查询条件
     * @return 总行数
     */
    long count(Patient patient);

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int insert(Patient patient);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Patient> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Patient> entities);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int update(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 影响行数
     */
    int deleteById(String patientId);

    /**
     * 通过userId查询单个Patient
     *
     * @param userId
     * @return
     */
    Patient queryByUserId(String userId);

    int updateByUserId(Patient patient);
}

