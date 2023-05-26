package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.ShoppingCartRepository;
import org.generation.FSDShoeDork.repository.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShoppingCartMySQL implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartMySQL(@Autowired ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ArrayList<Cart> findCartByUserId(Integer userId) {

        return this.shoppingCartRepository.findCartByUserId(userId);
    }


    public Cart save(Cart cart) {
        return this.shoppingCartRepository.save(cart);
    }

    public double calculateSubtotalByUserId(Integer userId) {
        double subtotal = 0;
        ArrayList<Cart> userCartItems = shoppingCartRepository.findCartByUserId(userId);
        for (Cart cartItem: userCartItems) {
            subtotal += cartItem.getProductPrice() * cartItem.getQty();
        }
        return Math.round(subtotal * 100.00) / 100.00;
    }

    public int calculateCartQtyByUserId(Integer userId) {
        int cartQty = 0;
        ArrayList<Cart> userCartItems = shoppingCartRepository.findCartByUserId(userId);
        for (Cart cartItem: userCartItems) {
            cartQty += cartItem.getQty();
        }
        return cartQty;
    }

    public double calculateCartTax(double subtotal) {
        double taxRate = 0.08;
        double taxAmount = taxRate * subtotal;
        return Math.round(taxAmount * 100.00) / 100.00;
    }

    public double calculateShoppingCost(double subtotal, double taxAmount, int cartQty) {
        double shippingCostPerItem;
        double freeShippingThreshold = 99.0;

        if (subtotal + taxAmount > freeShippingThreshold) {
            shippingCostPerItem = 0;
        } else {
            shippingCostPerItem = 10.0;
        }

        double shippingCost = shippingCostPerItem * cartQty;
        return Math.round(shippingCost * 100.00) / 100.00;
    }

    public double calculateTotalCost(double subtotal, double taxAmount, double shippingCost) {
        double totalCost = subtotal + taxAmount + shippingCost;
        return Math.round(totalCost * 100.00) / 100.00;
    }

    public void delete(int shoppingCartId) {
        this.shoppingCartRepository.deleteById(shoppingCartId);
    }


}
