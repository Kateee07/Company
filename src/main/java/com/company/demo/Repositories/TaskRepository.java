package com.company.demo.Repositories;

import com.company.demo.Entity.Task;
import com.company.demo.Projections.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM TASK", nativeQuery = true)
    List<Task> taskList();

    @Query(value = "SELECT SUM(W.TIME_OF_WORK) FROM TASK T INNER JOIN WORK_TIME W ON T. TASK_ID= W.TASK_ID WHERE T.TASK_ID=3", nativeQuery = true)
    Double sumOfWorkTimeToTask();

    @Query(value = "SELECT * FROM TASK T WHERE T.EMPLOYEE_ID= :id and T.STATUS_STATUS_ID=1", nativeQuery = true)
    List<Task> inProgressTaskForEmployeeById(@Param("id") int employeeId);

    @Query(value = "SELECT * FROM TASK T WHERE PROJECT_PROJECT_ID= :id AND STATUS_STATUS_ID=11", nativeQuery = true)
    List<Task> inProgressTaskListForProjectById(@Param("id") int projectId);

    @Query(value = "SELECT * FROM TASK T INNER JOIN PROJECT P ON T.PROJECT_PROJECT_ID = P.PROJECT_ID WHERE P.STATUS_ID= 2", nativeQuery = true)
    List<Task> taskListWhenProjectIsFinished(@Param("id") int projectId);

    @Query(value = "SELECT * FROM TASK T INNER JOIN PROJECT P ON T.PROJECT_PROJECT_ID = P.PROJECT_ID WHERE P.PRIORITY_ID= :id", nativeQuery = true)
    List<Task> taskListByProjectPriority(@Param("id") int priorityId);

    @Query(value = "SELECT T.TASK_ID, T.DESCRIPTION, T.ESTIMATE_TIME, W.TIME_OF_WORK FROM TASK T INNER JOIN PROJECT P ON T.PROJECT_PROJECT_ID = P.PROJECT_ID " +
            " INNER JOIN WORK_TIME W ON T.TASK_ID=W.TASK_ID WHERE P.PROJECT_ID= :id AND W.TIME_OF_WORK > T.ESTIMATE_TIME", nativeQuery = true)
    List<Task> listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheProject(@Param("id") int projectId);

    @Query(value = "SELECT T.TASK_ID, T.DESCRIPTION, T.ESTIMATE_TIME, W.TIME_OF_WORK FROM TASK T INNER JOIN WORK_TIME W ON T.TASK_ID = W.TASK_ID " +
            "WHERE T.EMPLOYEE_ID= :id AND W.TIME_OF_WORK > T.ESTIMATE_TIME", nativeQuery = true)
    List<Task> listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheEmployee(@Param("id") int employeeId);



//    @Query(value = "SELECT T.TASK_ID, E.ID AS EMPLOYEE_ID, P.PROJECT_ID FROM TASK T INNER JOIN EMPLOYEE E ON E.ID=T.EMPLOYEE_ID INNER JOIN PROJECT P ON P.PROJECT_ID=T.PROJECT_PROJECT_ID", nativeQuery = true)
//    List<TaskEmployeeProject> listOfId();

    @Query(value = "SELECT T.TASK_ID AS taskId, E.ID AS employeeId, P.PROJECT_PROJECT_ID AS projectId FROM EMPLOYEE E INNER JOIN TASK T ON E.ID=T.EMPLOYEE_ID INNER JOIN PROJECT_TASKS P ON P.PROJECT_PROJECT_ID=T.PROJECT_PROJECT_ID GROUP BY T.TASK_ID", nativeQuery = true)
    List<EmployeeView> findPersonAndTaskId();




}
