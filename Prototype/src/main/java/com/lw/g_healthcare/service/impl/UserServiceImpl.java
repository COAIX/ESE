package com.lw.g_healthcare.service.impl;


import com.lw.g_healthcare.dao.UserDao;
import com.lw.g_healthcare.entity.Patient;
import com.lw.g_healthcare.entity.User;
import com.lw.g_healthcare.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


/**
 * (User) Service Implementation
 */
@Service("userService")
public class UserServiceImpl implements UserService {



    @Resource
    private UserDao userDao;


    @Autowired
    private PatientServiceImpl patientService;


    /**
     * Query a single data by primary key
     *
     * @param userId primary key
     * @return query result
     */
    @Override
    public User queryById(String userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * Paging query
     *
     * @param user       filter condition
     * @param pageRequest paging object
     * @return query result
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * Add data
     *
     * @param user instance object
     * @return
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
            this.patientService.insert(patient);
//            String url = "http://patientservice/patient";
//            restTemplate.postForLocation(url, patient);
            return user;
        }
        return null;
    }

    /**
     * Modify data
     *
     * @param user instance object
     * @return
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * Delete data by primary key
     *
     * @param userId primary key
     * @return
     */
    @Override
    public boolean deleteById(String userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * Query all data
     *
     * @return
     */
    @Override
    public User queryByEmail(String email) {
        return this.userDao.queryByEmail(email);
    }

}

