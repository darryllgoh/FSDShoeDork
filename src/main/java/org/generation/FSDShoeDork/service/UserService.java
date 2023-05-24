package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.entity.User;

import java.util.ArrayList;

public interface UserService {

    //save method is for 2 purposes - Create new item & Update existing item
    User save(User user);

    //Delete item from database - based on item Id
    void delete(int userId);

    //Read all item from database
    ArrayList<User> all();

    //Read an item from database - based on item Id
    User findById(int userId);

    Integer findUserIdByUserName(String username);
}

