package com.study.study01.member.service;

import com.study.study01.exception.MemberException;
import com.study.study01.exception.MemberExceptionType;
import com.study.study01.member.domain.Member;
import com.study.study01.member.repository.MemberRepository;
import com.study.study01.util.CrytorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    private CrytorUtil crytorUtil = new CrytorUtil();
    @Override
    public void save(Member member) {
        member.setEmail(crytorUtil.encodeAesByte(member.getEmail()));
        if(memberRepository.findByEmail(member.getEmail()).isPresent()){
            throw new MemberException(MemberExceptionType.ALREADY_JOINED_MEMEBER);
        }
        member.setIdCd(generateRandomKey());
        member.setPwd(crytorUtil.encodeSHA256(member.getPwd()));
        member.setUserNm(crytorUtil.encodeAesByte(member.getUserNm()));
        member.setPhone(crytorUtil.encodeAesByte(member.getPhone()));
        memberRepository.save(member);
    }

    @Override
    public List<Member> checkMember(String email) {
        return null;
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
