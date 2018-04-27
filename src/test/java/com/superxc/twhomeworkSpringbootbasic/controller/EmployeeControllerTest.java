package com.superxc.twhomeworkSpringbootbasic.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    
    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
    }

    @Test
    public void should_return_bracket_when_do_not_have_employees() throws Exception{
        mvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void should_return_added_employee_when_add_employee() throws Exception{
        addEmployee("小明", 20, "男")
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":0,\"name\":\"小明\",\"age\":20,\"gender\":\"男\"}")));
    }

    @Test
    public void should_return_employees_list_when_have_employees() throws Exception{

    }

    private ResultActions addEmployee(String name, Integer age, String gender) throws Exception {
        return mvc.perform(post("/employees")
                                        .param("name", name)
                                        .param("age", age + "")
                                        .param("gender", gender));
    }
}
