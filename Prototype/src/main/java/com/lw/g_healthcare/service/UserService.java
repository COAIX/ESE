package com.lw.g_healthcare.service;


import com.lw.g_healthcare.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/**
 * (User) User Service
 * Interface
 */
public interface UserService {

    /**
     * Query a single data by primary key
     *
     * @param userId  primary key
     */
    User queryById(String userId);

    /**
     * Paging query
     *
     * @param user       filter condition
     * @param pageRequest paging object
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * Add data
     *
     * @param user  instance object
     */
    User insert(User user);

    /**
     * Modify data
     *
     * @param user  instance object
     */
    User update(User user);

    /**
     * Delete data by primary key
     *
     * @param userId  primary key
     */
    boolean deleteById(String userId);

    /**
     * Query all data
     */
    User queryByEmail(String email);


}
