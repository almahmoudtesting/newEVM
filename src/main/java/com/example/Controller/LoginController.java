package com.example.Controller;


import com.example.DTOs.LoginBody;
import com.example.DTOs.UserDTO;
import com.example.ServiceImplementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

//    @GetMapping("/UserData")
//    public ResponseEntity hello(Principal principal) {
//
//        // userService.fidByUserName().get().getUserid();
//        // userService.findById().get().setRolesname();
//        Map<String, Object> map = new HashMap<>();
//        map.put("userID", userService.findByUserName(principal.getName()).getUserid());
//        map.put("Role", userService.findByRolesName(principal.getName()).getRolesname());
//
//        return ResponseEntity.ok(map);
//    }

    @PostMapping("/UserData")
    public ResponseEntity hello(@RequestBody LoginBody loginBody) {
        if (!userService.existsByUsernameAndAndEnabledTrue(loginBody.getUsername())) {
            throw new RuntimeException("User Login Failed");
        }
        UserDTO userDTO1 = userService.findByUserName(loginBody.getUsername());
        if (userService.isUserEnabled(userDTO1.getUserid()) && new BCryptPasswordEncoder().matches(loginBody.getUserpassword(), userDTO1.getUserpassword())) {
            Map<String, Object> map = new HashMap<>();
            map.put("userID", userDTO1.getUserid());
            map.put("Role", userService.findByRolesName(loginBody.getUsername()).getRolesname());
            return ResponseEntity.ok(map);
        } else {
            throw new RuntimeException("Password incorrect");
        }
    }
}