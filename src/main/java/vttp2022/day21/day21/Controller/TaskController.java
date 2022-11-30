package vttp2022.day21.day21.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.day21.day21.service.TaskService;
import vttp2022.day21.day21.service.UserService;

@Controller
@RequestMapping(path = "/task")
public class TaskController {
    
    @Autowired
    private UserService userSrc;
    @Autowired
    private TaskService taskSrc;

    @PostMapping
    public String createTask(@RequestBody MultiValueMap<String, String> form, Model model){

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String taskName = form.getFirst("taskname");
        String priority = form.getFirst("priority");
        String completion = form.getFirst("completion");

        if (!userSrc.authenticate(username, password))
            return "failAuth";

        taskSrc.createTask(taskName, priority, username, completion);
        return "createTask";
    }

}
