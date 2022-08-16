package com.ggshin.ggprojectsolo.member.service;

import com.ggshin.ggprojectsolo.member.Member;
import com.ggshin.ggprojectsolo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Member 전체 조회
    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page,size, Sort.by("memberId").descending()));
    }

    //Member 조건 조회
    public Page<Member> findMembersByCondition(int page, int size, String location, String companyCode) {
        //TODO: 수정해야함
        Pageable pageable = PageRequest.of(page, size, Sort.by("memberId").descending());
        Optional<Page<Member>> optionalPageMembers =
                memberRepository.findByCompanyLocationAndCompanyType(location, companyCode, pageable);
        System.out.println(optionalPageMembers);


        return optionalPageMembers.orElseThrow();

    }
}
