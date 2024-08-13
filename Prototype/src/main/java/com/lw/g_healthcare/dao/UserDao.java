package com.lw.g_healthcare.dao;


import com.lw.g_healthcare.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (User) User Dao
 * Interface
 */
public interface UserDao {

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
     * @param pageable paging object
     */
    List<User> queryAllByLimit(User user, @Param("pageable") Pageable pageable);

    /**
     * Query all data
     */
    long count(User user);

    /**
     * Add data
     *
     * @param user  instance object
     */
    int insert(User user);

    /**
     * Add data
     *
     * @param entities  instance object
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * Add data
     *
     * @param entities  instance object
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * Modify data
     *
     * @param user  instance object
     */
    int update(User user);

    /**
     * Delete data by primary key
     *
     * @param userId  primary key
     */
    int deleteById(String userId);

    /**
     * Query all data
     */
    User queryByEmail(String email);

}

