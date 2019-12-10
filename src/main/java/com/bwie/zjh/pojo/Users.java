package com.bwie.zjh.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_user")
@Entity
@Data
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//包含id

    @Column(name = "name")
    private String name;//姓名

    @Column(name = "birthday")
    private Date birthday;// 生日，

    @Column(name = "gender")
    private String gender;// 性别，

    @Column(name = "nativep")
    private String nativep;// 籍贯，

    @Column(name = "descs")
    private String descs;// 住址。
}
