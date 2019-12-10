package com.bwie.zjh.mapper;

import com.bwie.zjh.pojo.Users;
import com.bwie.zjh.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserMapper extends JpaRepository<Users,Long>{
    //分页查询
   public Page<Users> findAll(Pageable pageable);
   //生日倒序
    public Page<Users> findByBirthdayLessThan(Date birthday,Pageable pageable);
    //11.	在Service层实现根据ID查询用户方法（4分）
    public Optional<Users> findById(Long id);
    //12.	在Service层实现根据ID删除用户方法（4分）
    void deleteById(Long id);
    //14.	在Service层实现根据性别查询方法（4分）
    public List<Users> findByGender(String gender);
    //15.	定义一个UserRepository接口定义一个方法findByUserNameLike（3
    public List<Users> findByNameLike(String name);
}
