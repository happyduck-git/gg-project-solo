package com.ggshin.ggprojectsolo.member.mapper;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import com.ggshin.ggprojectsolo.member.entity.Member;
import com.ggshin.ggprojectsolo.member.dto.MemberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberDtoToMember(MemberDto.Post memberDto);

    MemberDto.Response memberToMemberResponse(Member member);
//    default MemberDto.Response memberToMemberResponse(Member member) {
//        //memberId
//        long memberId = member.getMemberId();
//        String memberName = member.getName();
//        String sex = member.getSex();
//        String companyName = member.getCompanyName();
//        CompanyType companyType = new CompanyType();
//        companyType.setCompanyCode(member.get);
//        CompanyLocation companyLocation = new CompanyLocation();
//        MemberDto.Response response = new MemberDto.Response(memberId, memberName, sex, companyName, companyType, companyLocation);
//    };

    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
