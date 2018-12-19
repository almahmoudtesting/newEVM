package com.example.Repository;

import com.example.Entity.Roles;
import com.example.Entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends CrudRepository<Roles,String> {
//    Optional<Roles> findByRolesname(String name);

}
