package com.company.demo.demo;

import com.company.demo.Repositories.*;
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

import static net.minidev.json.JSONValue.toJSONString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    com.company.demo.Services.RandomDatabase randomDatabase;

    @MockBean
    com.company.demo.Services.EmployeeService employeeService;

    @Mock
    private com.company.demo.Repositories.ProjectRepository projectRepository;

    private com.company.demo.Entity.Employee employee = new com.company.demo.Entity.Employee();

    @Before
    public void init() {

        randomDatabase.init();
        randomDatabase.getRandomEmployee();
        randomDatabase.getRandomTask();
        randomDatabase.getRandomProjects();

        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setSalary(15000);
        employee.setTarget(true);
    }

    @Test
    public void shouldAddEmployeeToRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/company/add")
                .content(toJSONString(employee))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldUpdateSalary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/updateSalary")
                .param("id", "1")
                .param("salary", "14000")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddEmployeeWithAdress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/company/addWithAdress")
                .param("name", "Kate")
                .param("lastName", "Jordan")
                .param("position", "1")
                .param("birthDate", "2002-02-01")
                .param("salary", "14000")
                .param("startWorkDate", "2021-02-01")
                .param("target", "true")
                .param("city", "Poznan")
                .param("street", "Krucza")
                .param("houseNumber", "12")
                .param("postCode", "61-987")
                .param("endWorkDate", "2030-02-01")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAsignToSupervisor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/company/supervisor")
                .param("idEmployee", "8")
                .param("idEmployee2", "12")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldFireEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/company/fire")
                .param("id", "8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldFireEmployeeByEndWorkDate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/endWork")
                .param("id", "8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetSupervisor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/getSupervisor/{id}", 1)
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetListOFProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/getListOFProject/{employeeId}", 1)
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetEmployeeListWhenEmployeeIsSupervisor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/isSuper/{employeeId}", 1)
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetListAllEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/get")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetEmployeeById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/getByID/{id}", 5)
                .param("id", "5")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldUpdateAddress() throws Exception {
        com.company.demo.Entity.Address adress = new com.company.demo.Entity.Address();
        adress.setCity("Coś tam");
        adress.setPostCode("10525");
        adress.setStreet("Nowa");
        adress.setHouseNumber("2");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/company/updateAddress")
                .param("employeeId", "5")
                .content(toJSONString(adress))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldDeleteAddressFromEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/company/deleteAddress")
                .param("employeeId", "5")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldAddTransactionalChanges() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/addTransactionalChanges")
                .param("empId", "5")
                .param("salary", "25000")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldChangeAddressAndSalary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/changeAddressAndSalary")
                .param("empId", "5")
                .param("city", "New York")
                .param("salary", "25000")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetSumOfSalaryAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAverageSalaryAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/averageSalAll")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAverageSalaryWorkers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgSaLWorkers")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAverageSalaryDirectorWithBonuss() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgSaLDirectorWithBonus")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAverageSalaryDirectorWithoutBonus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgSaLDirectorWithoutBonus")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetSumSalaryOfPosition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/sumSalPos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetSumSalaryWorkers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/sumSalWorker")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAvgSalOlderThan50() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgSal50")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetSalaryByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/salary/{id}", 1)
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAvgAge() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgAge")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetAvgAgeForPosition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/avgAgePos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldEditName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/editName")
                .param("id", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldEditLastName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/editLastName")
                .param("id", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldEditSalary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/company/editSalary")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void shouldGetEmployeeByProjectId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/company/findEmployeeByProjectID/{id}", 1)
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}
