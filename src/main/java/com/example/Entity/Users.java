package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(name = "Users")

public class Users {

    public Users() {
    }


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

    @ManyToOne
    @JoinColumn(referencedColumnName = "rolesname",name="rolesname")
    private Roles rolesname;


private  boolean enabled=true;

    @Size( max = 30)
    private String usercity;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public Roles getRolesname() {
        return rolesname;
    }

    public void setRolesname(Roles rolesname) {
        this.rolesname = rolesname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsercity() {
        return usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

    public LocalDate getUserdob() {
        return userdob;
    }

    public void setUserdob(LocalDate userdob) {
        this.userdob = userdob;
    }
}

