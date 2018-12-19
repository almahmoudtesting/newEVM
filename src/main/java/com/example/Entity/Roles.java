package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {

    public Roles(){}


    @Id
    private String rolesname;

    public String getRolesname() {
        return rolesname;
    }

    public void setRolesname(String rolesname) {
        this.rolesname = rolesname;
    }


}
