package com.example.ServiceInterface;

import com.example.Entity.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesInterface {
     Iterable<Roles> findAll();
   // Optional<Roles> findById(Long id);
    Optional<Roles> findByRolesname(String name);
    void deleteById(Long id);
}
