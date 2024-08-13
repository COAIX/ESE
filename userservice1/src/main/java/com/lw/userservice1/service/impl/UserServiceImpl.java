package com.lw.userservice1.service.impl;

import com.lw.userservice1.dao.UserDao;
import com.lw.userservice1.entity.Patient;
import com.lw.userservice1.entity.User;
import com.lw.userservice1.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public RestTemplate restTemplate;

    @Resource
    private UserDao userDao;

    /**
     * 通过 userId 查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {

        int insert = this.userDao.insert(user);
        if (insert > 0) {
            //generate patientId as uuid, load the information in user into the patient table
            String patientId = UUID.randomUUID().toString();
            Patient patient = new Patient();
            patient.setPatientId(patientId);
            patient.setUserId(user.getUserId());
            patient.setEmail(user.getEmail());
            patient.setPhone(user.getPhone());
            patient.setName(user.getName());
            patient.setPrivacyConsent(0);
            //nacos调用患者服务，url为http://patientservice/patient/userId/，为put请求
            String url = "http://patientservice/patient";
            restTemplate.postForLocation(url, patient);
            return user;
        }
        return null;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过 userId 删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * 通过email查询单个User
     *
     * @param email
     * @return 单条数据
     */
    @Override
    public User queryByEmail(String email) {
        return this.userDao.queryByEmail(email);
    }

}

