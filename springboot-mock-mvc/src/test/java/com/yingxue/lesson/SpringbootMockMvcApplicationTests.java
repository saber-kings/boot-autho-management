package com.yingxue.lesson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.yingxue.lesson.model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SpringbootMockMvcApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    private final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void mockMvcGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/user")
                .contentType(APPLICATION_JSON_UTF8)
                .accept(APPLICATION_JSON_UTF8)
                .param("name", "zhangsan")
                .param("userId", "211"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("211"))
                .andExpect(jsonPath("$.name").value("zhangsan"))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void mockMvcPost() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("985");
        userInfo.setName("lisi");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(userInfo);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/test/user")
                .contentType(APPLICATION_JSON_UTF8)
                .content(json)
                .accept(APPLICATION_JSON_UTF8))
                    .andDo(print())
                    .andExpect(jsonPath("$.userId").value("985"))
                    .andExpect(jsonPath("$.name").value("lisi"))
                    .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
