package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.entity.Cart;

import java.util.ArrayList;

public interface ShoppingCartService {

    //Read all shoppingCart items by User ID
    ArrayList<Cart> findCartByUserId(Integer userId);

//    //Save method is for 2 purposes - Create new shopping cart & Update existing shoppingCart
//    Cart save(Cart cartEntry);
//
    //Delete shoppingCart from database - based on shoppingCart ID
    void delete(int shoppingCartId);
//
//    //Read all shoppingCart items from database
//    ArrayList<Cart> all();
//
//    //Read a shoppingCart item from database - base on shoppingCart ID
//    Cart findById(int shoppingCartId);



}
