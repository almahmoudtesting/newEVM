package com.example.Controller;


import com.example.ServiceImplementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping
@RestController
public class LoginController {

@Autowired
private UserService userService;
    @GetMapping("/UserData")
    public ResponseEntity hello(Principal principal) {

          // userService.fidByUserName().get().getUserid();
        // userService.findById().get().setRolesname();
        Map<String,Object> map = new HashMap<>();
        map.put("userID",userService.findByUserName(principal.getName()).getUserid());
        map.put("Role",userService.findByRolesName(principal.getName()).getRolesname());

        return ResponseEntity.ok(map);
    }

    }


