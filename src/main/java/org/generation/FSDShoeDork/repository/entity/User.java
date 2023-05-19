package org.generation.FSDShoeDork.repository.entity;

//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.generation.FSDShoeDork.controller.dto.UserDTO;

@Entity
public class User {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by SpringBoot framework)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue because our primary key is auto generated
    private Integer id; //wrapper not primitive
    //retrieve product item by ID - has to be an object - primary key
    //all keys should map the same name to the db columns

    private String username;
    private String password;
    private String role;
    private Integer enabled;

    public User() {}
    //Item class used to map with DB table
    //Any CRUD operation, JPA will make use of this item class to map.
    //For read or delete operation, the JPA requires an empty constructor to populate all records from the db as item
    // instances

    //Constructor overloading

    // DTO - data transfer object is set up in the controller layer
    // DTO is for create and update, sent via controller.
    public User(UserDTO userDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.role = "ROLE_ADMIN";
        this.enabled = 1;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", username='" + username + '\'' + ", password='" +
                password + '\'' + ", role='" +
                role + '\'' + ", enabled='" +
                enabled + '}';
    }

}
