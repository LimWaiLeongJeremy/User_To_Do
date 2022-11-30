package vttp2022.day21.day21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.day21.day21.model.Task;
import vttp2022.day21.day21.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public void createTask(String taskName, String priority, String assignTo, String completion){
        Task task = new Task();
        task.setTaskName(taskName);
        task.setPriority(priority);
        task.setAssigntTo(assignTo);
        task.setCompletion(completion);

        int count = taskRepo.createTask(task);
        System.out.printf("Service >>>>> create task count: %d", count);
    }
}
