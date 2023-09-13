package com.study.study01;

import com.study.study01.member.domain.Member;
import com.study.study01.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@SpringBootTest
public class MemberTest {
    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    private final AesBytesEncryptor aesBytesEncryptor;

    @Autowired
    public MemberTest(MemberService memberService, PasswordEncoder passwordEncoder, AesBytesEncryptor aesBytesEncryptor) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
        this.aesBytesEncryptor = aesBytesEncryptor;
    }

    @Test
    public void encrypt() throws UnsupportedEncodingException {
        String origin = "test1234@test.com";
        byte[] aes = aesBytesEncryptor.encrypt(origin.getBytes(StandardCharsets.UTF_8));
        String aText = new String(Base64.getEncoder().encode(aes));
        System.out.println("new String(aes, \"UTF-8\") = " + aText);
        String dec = new String(aesBytesEncryptor.decrypt(Base64.getDecoder().decode(aText)));
        assertEquals(origin, dec);

    }

    @Test
    public void 회원가입여부() throws Exception{
        Member member = new Member();
        member.setUserNm("테스트1");
        member.setPhone("010-1111-2222");
        member.setEmail("test1234@test.com");
        member.setPwd("test1234");
        member.setBirth(new Date());
        member.setSex("M");
        memberService.save(member);

    }

}
