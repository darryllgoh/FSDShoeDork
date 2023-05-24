package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.UserRepository;
import org.generation.FSDShoeDork.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserServiceMySQL implements UserService {
    //partial setup
    //implement methods from ItemService.java
    //ItemServiceMySQL class will provide all the implementation of all the methods that is provided in the interface.

    //This ItemServiceMySQL class has to depend on another class object to perform CRUD actions (e.g. save, delete, all, findItemById
    //dependent object class is the CRUDRepository class that is provided by Spring boot

    //to perform dependency injection -> access the CRUDRepository class through the ItemRepository interface that we
    // have created

    //ItemRepository is an interface that extends the CRUDRepository
    private final UserRepository userRepository;

    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation

    public UserServiceMySQL(@Autowired UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user)
    {
        //since we have done the dependency injection of ItemRepository, now we can call any methods from the
        // CRUDRepository class.
        return this.userRepository.save(user);
    }

    @Override
    public void delete(int userId)
    {
        this.userRepository.deleteById(userId);
    }

    @Override
    public ArrayList<User> all()
    {
        //@query - query class provided by Springboot. Select * from item
        //repository class provided by Springboot: we do not need to write a single query statement.
        ArrayList<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public User findById(int userId)
    {
        //optional is object that accept either a null (empty) or with items.
        Optional<User> user = userRepository.findById(userId);
        User userResponse = user.get();
        return userResponse;
    }

//    public boolean isUserExists(String username) {
//        // Assuming you have a Connection object representing your MySQL database connection
//        try (Connection connection = userRepository.findByUsername(username)) {
//            String query = "SELECT COUNT(*) FROM users WHERE username = ?";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setString(1, username);
//
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        int count = resultSet.getInt(1);
//                        return count > 0;
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            // Handle the exception appropriately
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    @Override
    public Integer findUserIdByUserName(String username) {
        //optional is object that accept either a null (empty) or with items.
        Optional<Integer> userOptional = userRepository.findUserIdByUserName(username);
        Integer userIdResponse = userOptional.get();
        return userIdResponse;
    };

}
