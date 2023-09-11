package com.study.study01.member.controller;

import com.study.study01.member.entity.Member;
import com.study.study01.member.repository.MemberRepository;
import com.study.study01.member.service.MemberService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    private final AesBytesEncryptor aesBytesEncryptor;

/*
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
*/

    @PostMapping("/sign")
    @ResponseBody
    public Member signMember(@RequestBody Member member){

        System.out.println("member.getEmail() = " + member.getEmail());
        System.out.println("passwordEncoder.encode(member.getEmail()) = " + aesBytesEncryptor.encrypt(member.getEmail().getBytes(StandardCharsets.UTF_8)));
        //System.out.println("passwordEncoder.encode(member.getEmail()) = " + aesBytesEncryptor.decrypt(aes));
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        //memberService.insertMember(member);
        return member;
    }

    public String byteArrayToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte abyte :bytes){
            sb.append(abyte);
            sb.append(" ");
        }
        return sb.toString();
    }

    public byte[] stringToByteArray(String byteString) {
        String[] split = byteString.split("\\s");
        ByteBuffer buffer = ByteBuffer.allocate(split.length);
        for (String s : split) {
            buffer.put((byte) Integer.parseInt(s));
        }
        return buffer.array();
    }

}
