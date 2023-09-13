package com.study.study01.member.service;

import com.study.study01.member.domain.Member;

import java.util.List;


public interface MemberService {
    void save(Member member) throws Exception;

    List<Member> checkMember(String email);


}
