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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RandomDatebasedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    com.example.demo.Services.RandomDatabase randomDatabase;

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
    public void shouldInitCompany() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/init")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddRandomPersons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddRandomProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddRandomAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/adress")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddRandomTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddTaskToProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/addTaskToProject")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddAdressToEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/addAdressToEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddEmployeeToProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/addEmployeeToProject")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddaddEmployeeToProject2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/random/addEmployeeToProject2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

}
