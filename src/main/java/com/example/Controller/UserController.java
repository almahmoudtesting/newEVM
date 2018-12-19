package com.example.Controller;
/* http://www.appsdeveloperblog.com/spring-mvc-postmapping-getmapping-putmapping-deletemapping/ */
import com.example.DTOs.UserDTO;
import com.example.Entity.Users;
import com.example.ServiceImplementation.UserService;
import com.example.ServiceInterface.UsersInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping (value = "/api/Users")
public class UserController {

    @Autowired
    public UsersInterface usersInterface;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping (value = "/AllUsers", method = RequestMethod.GET)
   // @PreAuthorize("(hasRole('ADMIN'))")
    public Iterable<Users> getAllUsers(){ return usersInterface.findAll(); }

    @RequestMapping(value = "/FindUsers/{id}")
    @PreAuthorize("(hasAnyRole('ADMIN','USER'))")
    public Optional<Users> findByIdd(@PathVariable Long id){return usersInterface.findById(id);}

    @PostMapping (value = "/AddUsers/{name}")
   // @PreAuthorize("(hasAnyRole('ADMIN','USER','ORGANIZER'))")
    public ResponseEntity AddUser(@Valid @RequestBody UserDTO userDTO, @PathVariable String name, BindingResult result){

      if (result.hasErrors()){
     return ResponseEntity.badRequest().body(result.getAllErrors());
      }
      return ResponseEntity.ok(usersInterface.AddUser(userDTO,name));

    }


       @PutMapping (value ="/UpdateUser/{uid}")
    public void UpdateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Long uid){
        usersInterface.UpdateUser(userDTO,uid);
    }

    @DeleteMapping (value = "/DeleteUser/{id}")
    @PreAuthorize("(hasRole('ADMIN'))")
    public void DeleteUser(@PathVariable Long id){usersInterface.DeleteUser(id);}
}