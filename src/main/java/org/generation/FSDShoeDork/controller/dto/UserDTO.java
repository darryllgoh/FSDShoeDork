package org.generation.FSDShoeDork.controller.dto;

//ItemDTO class is used for adding and updating of item services
//ID is autoincrement
public class UserDTO {

    private String email;
    private String password;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
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

}