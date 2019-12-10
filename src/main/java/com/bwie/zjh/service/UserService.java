package com.bwie.zjh.service;

import com.bwie.zjh.pojo.Users;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sun.nio.cs.US_ASCII;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService{
    //1查询所有
    List<Users> findAlls();

    //2.	在Service层实现添加用户方法（4分
    Users insertObject(Users entity);

    //3.	在Service层实现分页查询记录方法（4分）
    Page<Users> pageselect(Pageable pageable);

    //4.	在Service层实现分页查询记录并且根据生日倒排序方法（4分
    Page<Users> findDesc(Date birthday,Pageable pageable);

    //5.	在Service层实现根据ID查询用户方法（4分）
    Optional<Users> selectByid(Long id);

    //6根据ID删除用户方法
    void delete(Long id);

    //7.	在Service层实现添加用户方法（4分）+修改
    Users saveUsers(Users users);

    //8.	在Service层实现根据性别查询方法
    List<Users> selectbyGender(String gender);

    //9  Service层实现根据用户名模糊查找方法
    List<Users> selectByName(String name);
}
