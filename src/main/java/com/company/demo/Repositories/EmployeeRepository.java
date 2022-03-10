package com.company.demo.Repositories;


import com.company.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e from Employee e where e.id = :id")
    Employee findEmployeeByID(@Param("id") int id);

    //@Query(value = "SELECT * FROM Employee e INNER JOIN EM_PR p ON e.id = p.employee_id and  p.project_id = :id", nativeQuery = true)
    @Query(value = "select e from Employee e INNER join e.projects p where p.id = :id")
    List<Employee> findEmployeeFromProject(@Param("id") Integer projectId);

    @Query(value = "SELECT * FROM Employee", nativeQuery = true)
    List<Employee> getAllEmployee();

    @Query(value = "SELECT * FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID=3 ", nativeQuery = true)
    List<Employee> getEmployeeWithDirectorPosition();

    @Query(value = "SELECT * FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID=2 ", nativeQuery = true)
    List<Employee> getEmployeeWithManagerPosition();

    @Query(value = "SELECT * FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID=1 ", nativeQuery = true)
    List<Employee> getEmployeeWithWorkerPosition();

    @Query(value = "SELECT * FROM EMPLOYEE WHERE DATEDIFF(YY,BIRTH_DATE, CURRENT_DATE) > 50", nativeQuery = true)
    List<Employee> getEmployeeOlderThan50();



    @Query(value = "SELECT SUM(E.SALARY) FROM EMPLOYEE E", nativeQuery = true)
    Double getSumOfSalaryAllEmployee();

    @Query(value = "SELECT SUM(E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 1", nativeQuery = true)
    Double getSumOFSalaryWorkers();

    @Query(value = "SELECT SUM(E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 2", nativeQuery = true)
    Double getSumOFSalaryManagers();

    @Query(value = "SELECT SUM(E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 3", nativeQuery = true)
    Double getSumOFSalaryDirectors();




    @Query(value = "SELECT AVG(E.SALARY) FROM EMPLOYEE E", nativeQuery = true)
    Double getAvgSalaryAllEmployee();

    @Query(value = "SELECT AVG(E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 1", nativeQuery = true)
    Double getAvgSalaryWorkers();

    @Query(value = "SELECT AVG (E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 2", nativeQuery = true)
    Double getAvgSalaryManagers();

    @Query(value = "SELECT AVG (E.SALARY) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 3", nativeQuery = true)
    Double getAvgSalaryDirectors();


    @Query(value = "SELECT AVG(DATEDIFF(YY, E.BIRTH_DATE, CURRENT_DATE )) FROM EMPLOYEE E INNER JOIN WORK_POSITION P ON E.POSITION_ID= P.POSITION_ID WHERE P.POSITION_ID= 3", nativeQuery = true)
    Double getAvgAgeDirectors();



}
