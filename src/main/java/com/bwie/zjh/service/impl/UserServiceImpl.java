package com.bwie.zjh.service.impl;

import com.bwie.zjh.mapper.UserMapper;
import com.bwie.zjh.pojo.Users;
import com.bwie.zjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 8.	在Service层实现查询所有记录方法（4分），
     * @return
     */
    @Override
    public List<Users> findAlls() {
        List<Users> all = userMapper.findAll();
        return all;
    }

    @Override
    public Users insertObject(Users entity) {
        Users users = userMapper.saveAndFlush(entity);
        return users;
    }

    @Override
    public Page<Users> pageselect(Pageable pageable) {
        Page<Users> pagess = userMapper.findAll(pageable);
        return pagess;
    }

    @Override
    public Page<Users> findDesc(Date birthday,Pageable pageable) {
        return userMapper.findByBirthdayLessThan(birthday,pageable);
    }

    @Override
    public Optional<Users> selectByid(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public Users saveUsers(Users users) {
        Users users1 = userMapper.saveAndFlush(users);
        return users1;
    }

    @Override
    public List<Users> selectbyGender(String gender) {
        return userMapper.findByGender(gender);
    }

    @Override
    public List<Users> selectByName(String name) {
        return userMapper.findByNameLike(name);
    }


}
