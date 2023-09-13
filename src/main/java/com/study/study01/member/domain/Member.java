package com.study.study01.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ID_CD")
    private String idCd;
    @NotBlank(message="비밀번호를 입력해주세요.")
    private String pwd;
    @NotBlank(message="이메일을 입력해주세요.")
    private String email;
    @NotBlank(message="이름을 입력해주세요.")
    @Column(name="USER_NM")
    private String userNm;
    @NotBlank(message="폰 번호를 입력해주세요.")
    private String phone;
    private Date birth;
    private String sex;

}
