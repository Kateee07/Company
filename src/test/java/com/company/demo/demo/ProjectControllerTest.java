package com.company.demo.demo;

import com.example.demo.Entity.Priority;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.WorkPosition;
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

import java.util.Arrays;
import java.util.List;

import static net.minidev.json.JSONValue.toJSONString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    com.example.demo.Services.RandomDatabase randomDatabase;

    @MockBean
    com.example.demo.Services.ProjectService projectService;


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


    private com.example.demo.Entity.Project newProject = new com.example.demo.Entity.Project();

    public List<WorkPosition> initPositionPreper() {
        com.example.demo.Entity.WorkPosition workPosition = new com.example.demo.Entity.WorkPosition(1, "Worker");
        com.example.demo.Entity.WorkPosition workPosition1 = new com.example.demo.Entity.WorkPosition(2, "Manager");
        com.example.demo.Entity.WorkPosition workPosition2 = new com.example.demo.Entity.WorkPosition(3, "Director");
        com.example.demo.Entity.WorkPosition workPosition3 = new com.example.demo.Entity.WorkPosition(4, "Head");
        List<WorkPosition> workPositionList = Arrays.asList(workPosition, workPosition1, workPosition2, workPosition3);
        return workPositionList;
    }

    public List<Priority> initPriorityPreper() {

        com.example.demo.Entity.Priority priority = new com.example.demo.Entity.Priority(1, "Low");
        com.example.demo.Entity.Priority priority1 = new com.example.demo.Entity.Priority(2, "Medium");
        com.example.demo.Entity.Priority priority2 = new com.example.demo.Entity.Priority(3, "High");
        com.example.demo.Entity.Priority priority3 = new com.example.demo.Entity.Priority(4, "Critical");
        List<Priority> priorityList = Arrays.asList(priority, priority1, priority2, priority3);
        return priorityList;
    }

    public List<Status> initStatusPreper() {

        com.example.demo.Entity.Status status = new com.example.demo.Entity.Status(1, "Inprogress");
        com.example.demo.Entity.Status status1 = new com.example.demo.Entity.Status(2, "Done");
        com.example.demo.Entity.Status status2 = new com.example.demo.Entity.Status(3, "New");
        List<Status> statusList = Arrays.asList(status, status1, status2);

        return statusList;
    }

    @Before
    public void init() {

        randomDatabase.init();
        randomDatabase.getRandomEmployee();
        randomDatabase.getRandomTask();
        randomDatabase.getRandomProjects();

        com.example.demo.Entity.Status status = new com.example.demo.Entity.Status();
        status.setId(1);
        status.setStatus("Done");

        newProject.setName("Nowy");
        newProject.setStatus(status);
        newProject.setDeadLine(null);
        newProject.setPriority(null);

        List<Project> all = projectRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void shouldGetActualProjectsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/project/actual")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldCreateProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/project/create")
                .content(toJSONString(newProject))
                .param("name", "nowy")
                .param("statusID", "1")
                .param("localDate", "2002-01-02")
                .param("priorityID", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddEmployeeToProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/project/addEmployeeToProject")
                .param("projectId", "2")
                .param("employeeId", "7")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldUpdateProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/project/update")
                .param("id", "1")
                .param("date", "2002-01-21")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldSaveStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/project/saveStatus")
                .param("id", "1")
                .param("status", "2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetFinishedProjectsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/project/finished")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldDeleteProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/project/delete")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddTaskToProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/project/addTask")
                .param("projectId", "1")
                .param("name", "Nowy Task")
                .param("description", "Coś tamm")
                .param("estimateTime", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldFindProjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/project/findProjectById/{id}", 1)
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }


}
