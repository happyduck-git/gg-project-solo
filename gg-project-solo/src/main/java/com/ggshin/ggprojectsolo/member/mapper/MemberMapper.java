package com.ggshin.ggprojectsolo.member.mapper;

import com.ggshin.ggprojectsolo.member.Member;
import com.ggshin.ggprojectsolo.member.dto.MemberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
