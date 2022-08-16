package com.ggshin.ggprojectsolo.restdocs.member;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import com.ggshin.ggprojectsolo.member.Member;
import com.ggshin.ggprojectsolo.member.controller.MemberController;
import com.ggshin.ggprojectsolo.member.dto.MemberDto;
import com.ggshin.ggprojectsolo.member.mapper.MemberMapper;
import com.ggshin.ggprojectsolo.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.ggshin.ggprojectsolo.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.ggshin.ggprojectsolo.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberControllerRestDocsTest {
    //MockMvc는 Tomcat과 같은 서버를 실행하지 않고도 Spring 기반 애플리케이션의
    //Controller를 test할 수 있도록 해주는 일종의 Spring Mvc framework
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    //Application Context에 등록되어 있는 Bean 에 대한 Mockito Mock object를 생성하고 DI 해주는 역할
    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper memberMapper;

    //@Test를 붙여서 test 대상임을 알려주기
    @Test
    public void getMembersTest() throws Exception {

        //given
        MultiValueMap<String, String> pageMap = new LinkedMultiValueMap<>();
        String page = "1";
        String size = "10";
        pageMap.add("page", page);
        pageMap.add("size", size);

        CompanyType companyType = new CompanyType(1L, "IT", "001");
        CompanyLocation companyLocation = new CompanyLocation(1L, "Jeju", "064");
        Member member1 =
                new Member("신가경",
                        "Pass1234",
                        "F",
                        "가경회사",
                        companyType,
                        companyLocation);
        Page<Member> memberPage = new PageImpl<>(
                List.of(
                        member1
                )
        );
        MemberDto.Response response =
                new MemberDto.Response(
                        1L,
                        "신가경",
                        "F",
                        "가경회사",
                        companyType,
                        companyLocation
                );
        List<MemberDto.Response> responses = List.of(
                response
        );

        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(memberPage);
        given(memberMapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);


        //when
        ResultActions actions =
                mockMvc.perform(
                        get("/v1/members/")
                                .params(pageMap)

                );

        //then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                List.of(
                                        parameterWithName("page").description("페이지"),
                                        parameterWithName("size").description("사이즈")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("성별"),
                                        fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("회사명"),
                                        fieldWithPath("[].companyType").type(JsonFieldType.STRING).description("사업 분류"),
                                        fieldWithPath("[].companyLocation").type(JsonFieldType.STRING).description("회사 위치")
                                )
                        )

                ));

    }

    @Test
    public void getConditionalMembersTest() throws Exception {

        //given
        MultiValueMap<String, String> pageMap = new LinkedMultiValueMap<>();
        String page = "1";
        String size = "10";
        pageMap.add("page", page);
        pageMap.add("size", size);
        String locationCode = "064";
        String companyCode = "001";

            //member1 - condition satisfied
        CompanyType companyType1 = new CompanyType(1L, "IT", "001");
        CompanyLocation companyLocation1 = new CompanyLocation(1L, "Jeju", "064");
        Member member1 =
                new Member("신가경",
                        "Pass1234",
                        "F",
                        "가경회사",
                        companyType1,
                        companyLocation1);

            //member2 - condition not satisfied
        CompanyType companyType2 = new CompanyType(2L, "IT", "001");
        CompanyLocation companyLocation2 = new CompanyLocation(2L, "Incheon", "064");
        Member member2 =
                new Member("이희성",
                        "Pass1234",
                        "M",
                        "희성회사",
                        companyType2,
                        companyLocation2);

        Page<Member> memberPage = new PageImpl<>(
                List.of(
                        member1,
                        member2
                )
        );

        MemberDto.Response response1 =
                new MemberDto.Response(
                        1L,
                        "신가경",
                        "F",
                        "가경회사",
                        companyType1,
                        companyLocation1
                );
        MemberDto.Response response2 =
                new MemberDto.Response(
                        2L,
                        "이희성",
                        "M",
                        "희성회사",
                        companyType2,
                        companyLocation2
                );
        List<MemberDto.Response> responses = List.of(
                response1, response2
        );

        given(memberService.findMembersByCondition(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).willReturn(memberPage);
        given(memberMapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);

        //when
        ResultActions actions =
                mockMvc.perform(get("/v1/members/condition")
                        .params(pageMap)
                        .param("locationCode", locationCode)
                        .param("companyCode", companyCode)
                );

        //then
        actions
                .andExpect(status().isOk())
                .andDo(document("get-condition-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                List.of(
                                        parameterWithName("page").description("페이지"),
                                        parameterWithName("size").description("사이즈"),
                                        parameterWithName("locationCode").description("지역번호"),
                                        parameterWithName("companyCode").description("회사코드")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("성별"),
                                        fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("회사명"),
                                        fieldWithPath("[].companyType").type(JsonFieldType.STRING).description("사업 분류"),
                                        fieldWithPath("[].companyLocation").type(JsonFieldType.STRING).description("회사 위치")
                                )
                        )

                        ));

    }

}
