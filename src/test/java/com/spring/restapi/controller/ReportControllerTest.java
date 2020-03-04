package com.spring.restapi.controller;

import com.spring.restapi.common.BaseControllerTest;
import com.spring.restapi.report.model.Report;
import org.junit.Test;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ReportControllerTest extends BaseControllerTest {

    @Test
    public void init() throws Exception
    {
        //given
        Report report = Report.builder().isAddUrl(true).userId("haepyung").build();

        //when & then
       this.mockMvc.perform(get("/api/report/{userId}", report.getUserId()))
               .andDo(print())
               .andExpect(status().isOk())
               .andDo(document("report-init",
                       links(linkWithRel("self").description("link to self"),
                               linkWithRel("isAddUrlFalse").description("link to isAddUrlFalse"),
                               linkWithRel("profile").description("docs")
                       ),
                       //relaxedRequestFields(fieldWithPath("userId").description("UserId")),
                       relaxedResponseFields(fieldWithPath("userId").description("Report of userId"))
               ));
    }
}
