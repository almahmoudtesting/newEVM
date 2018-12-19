//package com.example.Controller;
//
//import com.example.Entity.Roles;
//import com.example.ServiceImplementation.RolesService;
//import com.example.ServiceInterface.RolesInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//@RequestMapping (value = "/api/Roles")
//@RestController
//public class RolesController {
//
//    @Autowired
//    public RolesInterface rolesInterface;
//
//    @RequestMapping (value = "/AllRoles", method = RequestMethod.GET)
//    public Iterable<Roles> getAllRoles(){ return rolesInterface.findAll(); }
//
//    @RequestMapping(value = "/FindRoles/{id}")
//    public Optional<Roles> findByIdd(@PathVariable Long id){return rolesInterface.findById(id);}
//}
