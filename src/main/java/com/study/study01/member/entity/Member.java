package com.study.study01.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
//@Table(name="Member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ID_CD")
    private String idCd;
    private String pwd;
    private String email;
    @Column(name="USER_NM")
    private String userNm;
    private String phone;
    private Date birth;
    private String sex;

}
