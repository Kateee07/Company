package com.company.demo.demo;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    com.example.demo.Services.RandomDatabase randomDatabase;

    @MockBean
    com.example.demo.Services.TaskService taskService;

    @Mock
    private com.example.demo.Repositories.TaskRepository taskRepository;

    @Before
    public void init() {

        randomDatabase.init();
        randomDatabase.getRandomEmployee();
        randomDatabase.getRandomTask();
        randomDatabase.getRandomProjects();
    }

    @Test
    public void shouldAssignEmployeeToTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/task/asignEmployee")
                .param("employeeId", "1")
                .param("taskId", "3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddWorkTime() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/task/addWorkTime")
                .param("taskId", "1")
                .param("date", "2002-02-03")
                .param("timeOfWork", "3")
                .param("description", "coś tam")
                .param("statusId", "1")
                .param("priorityId", "2")
                .param("employeeId", "7")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldEditWorkTime() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/task/editWorkTime")
                .param("taskId", "1")
                .param("extraWorkTime", "2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetListOfTaskByProjectId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/task/getListOfTaskByProjectId/{projectId}", 1)
                .param("taskId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetListOfWorkTime() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/task/showListOfWorkTimeToTask/{taskId}", 1)
                .param("taskId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldDeleteEmployeeFromTaskAndAddNew() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/task/fireAndAddNewEmployeeToTask")
                .param("taskId", "1")
                .param("employee2Id", "5")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

}
