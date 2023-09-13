package com.study.study01.member.controller;

import com.study.study01.member.domain.Member;
import com.study.study01.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

/*
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
*/

    @PostMapping("/sign")
    @ResponseBody
    public Member signMember(@RequestBody @Valid Member member) throws Exception {
        memberService.save(member);
        return member;
    }




}
