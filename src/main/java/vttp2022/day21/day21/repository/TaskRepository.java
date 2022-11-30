package vttp2022.day21.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.day21.day21.model.Task;

import static vttp2022.day21.day21.repository.Query.*;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createTask(Task task){
        return jdbcTemplate.update(SQL_INSERT_TASK
                    , task.getTaskName()
                    , task.getPriority()
                    , task.getAssigntTo()
                    , task.getCompletion());
    }
}
