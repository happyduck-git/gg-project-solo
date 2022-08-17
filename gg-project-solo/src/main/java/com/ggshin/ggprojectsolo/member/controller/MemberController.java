package com.ggshin.ggprojectsolo.member.controller;

import com.ggshin.ggprojectsolo.member.dto.MemberDto;
import com.ggshin.ggprojectsolo.member.entity.Member;
import com.ggshin.ggprojectsolo.member.mapper.MemberMapper;
import com.ggshin.ggprojectsolo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.Post memberPostDto) {

        System.out.println("From MemberController: (Post Dto) " + memberPostDto);

        //Dto to Entity
        Member member = memberMapper.memberDtoToMember(memberPostDto);

        System.out.println("From MemberController: (Entity) " + member);

        //send the entity to service
        memberService.createMember(member);

        //Entity to Response Dto
        MemberDto.Response response = memberMapper.memberToMemberResponse(member);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    //전체 회원 조회
    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> memberPage = memberService.findMembers(page - 1, size);
        List<Member> members = memberPage.getContent();
        return new ResponseEntity<>(memberMapper.membersToMemberResponses(members), HttpStatus.OK);
    }

    //지역, 비즈니스 타입에 따른 정보 조회
    @GetMapping("/condition")
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size,
                                     @RequestParam String locationCode,
                                     @RequestParam String companyCode) {
        Page<Member> memberPage = memberService.findMembersByCondition(page - 1, size, locationCode, companyCode);
        List<Member> members = memberPage.getContent();
        return new ResponseEntity<>(memberMapper.membersToMemberResponses(members), HttpStatus.OK);
    }

}
