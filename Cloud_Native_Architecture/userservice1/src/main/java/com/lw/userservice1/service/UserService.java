package com.lw.userservice1.service;


import com.lw.userservice1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    /**
     * 通过email查询单个User
     *
     * @return 单条数据
     */
    User queryByEmail(String email);


}
