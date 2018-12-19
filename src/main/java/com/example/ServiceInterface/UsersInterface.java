package com.example.ServiceInterface;
import com.example.DTOs.UserDTO;
import com.example.Entity.Roles;
import com.example.Entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public interface UsersInterface {
    Iterable<Users> findAll();
    Optional<Users> findById(Long id);
    void DeleteUser(Long id);
    Users  AddUser(UserDTO userDTO,String name);
     void UpdateUser(UserDTO userDTO, Long uid);

     UserDTO findByUserName(String a);
     Roles findByRolesName(String b);

}
