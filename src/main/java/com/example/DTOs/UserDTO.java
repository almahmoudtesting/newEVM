package com.example.DTOs;

import com.example.Entity.Roles;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long userid;

    @NotNull
    @Size(min = 2,max = 40)
    private String username;

    @NotBlank
    @NotNull
    private String userpassword;


    @Email
    @NotNull
    private String useremail;

    @NotNull
    private LocalDate userdob;

    @Size( max = 30)
    private String usercity;

    private Roles rolesid;

    public Roles getRolesid() {
        return rolesid;
    }

    public void setRolesid(Roles rolesid) {
        this.rolesid = rolesid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public LocalDate getUserdob() {
        return userdob;
    }

    public void setUserdob(LocalDate userdob) {
        this.userdob = userdob;
    }

    public String getUsercity() {
        return usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
