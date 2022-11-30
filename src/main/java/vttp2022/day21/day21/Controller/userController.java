package vttp2022.day21.day21.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.day21.day21.service.UserService;

@Controller
@RequestMapping(path = {"/user"})
public class userController {

    @Autowired
    private UserService userSrc;
    
    @PostMapping
    public String createUser(@RequestBody MultiValueMap<String, String> form, Model model){

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String email = form.getFirst("email");
        String dob = form.getFirst("dob");

        System.out.printf("Controller >>>> username: %s\n", username);

        try{
            userSrc.createUser(username, password, email, dob);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "User " + username + " already exists.");
            return "customError";
        }

        model.addAttribute("username", username);
        
        return "user";
        

    }
    
}
