package com.lw.userservice1.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lw.userservice1.entity.Patient;
import com.lw.userservice1.entity.User;
import com.lw.userservice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-07-11 05:18:49
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 负载均衡Restemple调用器
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @GetMapping("{userId}")
    @SentinelResource(value = "queryById")
    public ResponseEntity<User> queryById(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(this.userService.queryById(userId));
    }

    /**
     * 通过eamil查询单个User
     *
     * @return 单条数据
      */
    @GetMapping("email/{email}")
    public ResponseEntity<User> queryByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(this.userService.queryByEmail(email));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        if (user.getUserId().isEmpty()){
            System.out.println("userId is empty");
            return ResponseEntity.ok(null);
        }
        try {
            return ResponseEntity.ok(this.userService.insert(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok(null);
        }
    }

    /**
     * 查询user对应的patient是否创建
     * @param user
     * @return
     */
    @PostMapping("Check")
    public ResponseEntity<Boolean> checkPatient(@RequestBody User user) {
        String url = "http://patientservice/patient/userId/" + user.getUserId();
        try {
            Patient response = restTemplate.getForObject(url, Patient.class);
            return ResponseEntity.ok(true);
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.ok(false);
        }
    }



    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param userId 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String userId) {
        return ResponseEntity.ok(this.userService.deleteById(userId));
    }

}

