package org.generation.FSDShoeDork.controller.dto;

//ItemDTO class is used for adding and updating of item services
//ID is autoincrement
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private Integer enabled;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ROLE_USER"; // "role user"
        this.enabled = 1; // "integer"
    }

    //user sign up
    //https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "UserDTO {" + "username='" + username + '\'' + ", password='" +
                password + '\'' + ", role='" +
                role + '\'' + ", enabled='" +
                enabled + '}';
    }

}