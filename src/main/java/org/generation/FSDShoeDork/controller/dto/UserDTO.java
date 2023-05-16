package org.generation.FSDShoeDork.controller.dto;

//ItemDTO class is used for adding and updating of item services
//ID is autoincrement
public class UserDTO {

    private String email;
    private String password;
    private String role;

    public UserDTO(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //Average user sign up
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = "ROLE_USER";
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}