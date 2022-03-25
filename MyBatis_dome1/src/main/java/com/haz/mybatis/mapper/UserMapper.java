package com.haz.mybatis.mapper;

import com.haz.mybatis.pojo.User;

import java.util.List;

/**
 * @author: HAZ
 * @date: 2022/3/19
 * @Description:
 */

public interface UserMapper {

    /**
     * MyBatis 面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
     */

    /**
     * 添加用户信息
     * @return 受影响的行数
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     * @return 受影响的行数
     */
    int updateUser(User user);

    /**
     * 删除用户信息
     * @param id 用户ID
     */
    void deleteUser(Integer id);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return 返回一个用户信息
     */
    User getUserById(Integer id);

    /**
     * 查询所有用户信息
     * @return 返回用户信息列表
     */
    List<User> getAllUser();
}
