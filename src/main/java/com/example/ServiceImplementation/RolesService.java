package com.example.ServiceImplementation;

import com.example.Entity.Roles;
import com.example.Repository.RolesRepository;
import com.example.ServiceInterface.RolesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements RolesInterface {

    @Autowired
    private RolesRepository rolesRepository;

    public Iterable<Roles> findAll() {
        return  rolesRepository.findAll();
    }

  //  public Optional<Roles> findById(Long id) {
    //    return rolesRepository.findById(id);
   // }

    @Override
    public Optional<Roles> findByRolesname(String name) {
        return rolesRepository.findById(name);
    }

    @Override
    public void deleteById(Long id) {

    }
}
