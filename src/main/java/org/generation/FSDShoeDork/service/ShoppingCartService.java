package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.entity.Cart;

import java.util.ArrayList;

public interface ShoppingCartService {

    //Read all shoppingCart items by User ID
    ArrayList<Cart> findCartByUserId(Integer userId);

//    //Save method is for 2 purposes - Create new shopping cart & Update existing shoppingCart
//    Cart save(Cart cart);
//
    //Delete shoppingCart from database - based on shoppingCart ID
    void delete(int shoppingCartId);

    double calculateSubtotalByUserId(Integer userId);

    int calculateCartQtyByUserId(Integer userId);

    double calculateCartTax(double subtotal);

    double calculateShoppingCost(double subtotal, double taxAmount, int cartQty);

    double calculateTotalCost(double subtotal, double taxAmount, double shippingCost);


}
