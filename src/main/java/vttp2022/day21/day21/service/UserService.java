package vttp2022.day21.day21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.day21.day21.model.User;
import vttp2022.day21.day21.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public boolean createUser(String username, String password, String email, String dob) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDob(dob);

        int count = userRepo.createUser(user);
        System.out.printf("Service >>>>> create user count: %d", count);
    
        return count > 0;
    } 

    public boolean authenticate(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        return userRepo.authenticate(user);
    }
    


}
