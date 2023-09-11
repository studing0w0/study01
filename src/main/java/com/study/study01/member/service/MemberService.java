package com.study.study01.member.service;

import com.study.study01.member.entity.Member;
import com.study.study01.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void insertMember(Member member){
        member.setIdCd(generateRandomKey());
        memberRepository.save(member);
    }

    private String generateRandomKey(){
        Random r = new Random();
        String key = (char)(r.nextInt(26)+'A')+"";
        for(int i=0; i<9; i++){
            key = key+r.nextInt(9);
        }
        return key;

    }

}
