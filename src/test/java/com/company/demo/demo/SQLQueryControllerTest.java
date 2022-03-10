package com.company.demo.demo;


import com.example.demo.Repositories.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SQLQueryControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    com.example.demo.Services.RandomDatabase randomDatabase;

    @MockBean
    com.example.demo.Services.TaskService taskService;

    @Mock
    private com.example.demo.Repositories.ProjectRepository projectRepository;
    @Mock
    private com.example.demo.Repositories.AdressRepository adressRepository;
    @Mock
    private com.example.demo.Repositories.TaskRepository taskRepository;
    @Mock
    private com.example.demo.Repositories.EmployeeRepository employeeRepository;
    @Mock
    private com.example.demo.Repositories.PriorityRepository priorityRepository;
    @Mock
    private com.example.demo.Repositories.PositionRepository positionRepository;
    @Mock
    private com.example.demo.Repositories.StatusRepository statusRepository;

    @Before
    public void init() {

        randomDatabase.init();
        randomDatabase.getRandomEmployee();
        randomDatabase.getRandomTask();
        randomDatabase.getRandomProjects();
        randomDatabase.getRandomAdress();
    }

    @Test
    public void shouldGetSumOfSalaryAllEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/sumOfSalaryAllEmployee")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }


}
