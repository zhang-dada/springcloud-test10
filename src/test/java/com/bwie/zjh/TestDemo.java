package com.bwie.zjh;

import com.bwie.zjh.mapper.UserMapper;
import com.bwie.zjh.pojo.Users;
import com.bwie.zjh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
   @Autowired
    private UserService userServicel;


   @Autowired
   private UserMapper mapper;
    /**
     * 添加
     */
    @Test
    public void insert(){

        for (int i=0;i<=10;i++){
            Users users = new Users();
            users.setName("张三");
            users.setBirthday(new Date());
            users.setGender("nan");
            users.setDescs("hhhhh");
            users.setNativep("sssss");
            //测试添加10个不同的用户（3分）
            Users users1 = userServicel.insertObject(users);
        }
    }
    /**
     * 查询
     */
   @Test
    public void show(){
       List<Users> alls = userServicel.findAlls();
       for (Users all : alls) {
           System.out.println(all);
       }
   }
    /**
     * 分页查询
     */
   @Test
    public void pagesSe(){
       PageRequest of = PageRequest.of(0, 3);

       Page<Users> pagess = userServicel.pageselect(of);

       List<Users> content = pagess.getContent();

       for (Users users : content) {
           System.out.println(users);
       }
   }
    /**
     * 10.	在Service层实现分页查询记录并且根据生日倒排序方法（4分
     */
    @Test
    public void desc(){
        PageRequest birthday = PageRequest.of(0, 3, Sort.by(Sort.Order.desc("birthday")));

        Page<Users> desc = userServicel.findDesc(new Date(), birthday);
        List<Users> content = desc.getContent();
        for (Users users : content) {
            System.out.println(users);
        }
    }

    //id查询+修改
    @Test
    public void selectByid(){
        Users users = userServicel.selectByid(2L).get();
        users.setName("sssss");
        Users users1 = userServicel.saveUsers(users);
        System.out.println(users1);
    }
    @Test
    public void del(){
        userServicel.delete(3L);
        System.out.println("删除成功！");
    }
    @Test
    public void selectBygender(){
        List<Users> nan = userServicel.selectbyGender("男");
        for (Users users : nan) {
            System.out.println(users);
        }
    }

    @Test
    public void selectByname(){
        List<Users> users = userServicel.selectByName("%张%");
        for (Users user : users) {
            System.out.println(user);
        }
    }
}
