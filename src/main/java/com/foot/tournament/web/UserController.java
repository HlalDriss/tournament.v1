package com.foot.tournament.web;


import com.foot.tournament.dto.UserDto;
import com.foot.tournament.entities.User;
import com.foot.tournament.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User>  getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public void createUser(@RequestBody User user){
        String password=user.getPassword();
        String username=user.getUsername();
        User userChecked=userRepository.findByUsername(username);

        if (userChecked !=null) throw new RuntimeException("The User Already Exist !");

        String passwordEncrypting=  passwordEncoder.encode(password);
        System.out.println("############################################Controller IUser####");
        System.out.println(passwordEncrypting);
        System.out.println("################################################");
        user.setPassword(passwordEncrypting);
         userRepository.save(user);

    }
}
