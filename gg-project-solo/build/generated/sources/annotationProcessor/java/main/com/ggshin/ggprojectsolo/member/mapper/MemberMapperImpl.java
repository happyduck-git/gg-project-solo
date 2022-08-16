package com.ggshin.ggprojectsolo.member.mapper;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import com.ggshin.ggprojectsolo.member.Member;
import com.ggshin.ggprojectsolo.member.dto.MemberDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T18:47:02+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public List<MemberDto.Response> membersToMemberResponses(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberDto.Response> list = new ArrayList<MemberDto.Response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToResponse( member ) );
        }

        return list;
    }

    protected MemberDto.Response memberToResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String name = null;
        String sex = null;
        String companyName = null;
        CompanyType companyType = null;
        CompanyLocation companyLocation = null;

        memberId = member.getMemberId();
        name = member.getName();
        sex = member.getSex();
        companyName = member.getCompanyName();
        companyType = member.getCompanyType();
        companyLocation = member.getCompanyLocation();

        MemberDto.Response response = new MemberDto.Response( memberId, name, sex, companyName, companyType, companyLocation );

        return response;
    }
}
