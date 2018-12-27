package com.example.ServiceImplementation;

import com.example.DTOs.UserDTO;
import com.example.Entity.Roles;
import com.example.Entity.Users;
import com.example.Repository.RolesRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.UsersInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService implements UsersInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NotificationService notificationService;

    @Override
    public Users AddUser(UserDTO userDTO, String name) {

        Users users = new Users();
        users= modelMapper.map(userDTO,Users.class);
        users.setRolesname(rolesRepository.findById(name).get());
        users.setUserpassword(new BCryptPasswordEncoder().encode(userDTO.getUserpassword()));
        //notificationService.sendNotificaitoin(users.getUseremail(),"Event Management CO.",  "Welcome to our website \uD83D\uDE0A : "+ users.getUsername());
         return userRepository.save(users);
    }

    @Override
    public void UpdateUser(UserDTO userDTO,Long uid) {

        Users users1 = userRepository.findById(uid).get();
        Users users = modelMapper.map(userDTO,Users.class);

        if (userRepository.findById(uid).isPresent()){
        users.setUserid(uid);
        users.setRolesname(users1.getRolesname());
        userRepository.save(users);
    }}

    @Override
    public long countByEnabledTrueOrEnabledFalse() {
        return userRepository.countByEnabledTrueOrEnabledFalse();
    }

    @Override
    public UserDTO findByUserName(String a)
    {
       Users users =  userRepository.findByUsername(a);
        UserDTO users1 = modelMapper.map(users,UserDTO.class);
        return users1;
    }

    @Override
    public Roles findByRolesName(String b) {
       return rolesRepository.findById(userRepository.findByUsername(b).getRolesname().getRolesname()).get();

    }

    @Override
    public void EnabeleUser(Long id) {
        Users euser = userRepository.findById(id).get();
        euser.setEnabled(true);
        userRepository.save(euser);
    }


    public Iterable<Users> findAll() {
    return userRepository.findAll();
    }
    public Optional<Users> findById(Long id) {
    return userRepository.findById(id);
    }

    @Override
    public void DeleteUser(Long id) {
    Users duser = userRepository.findById(id).get();
    duser.setEnabled(false);
    userRepository.save(duser);

    }

}
