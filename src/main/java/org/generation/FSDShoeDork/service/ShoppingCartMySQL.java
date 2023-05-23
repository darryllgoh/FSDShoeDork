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

//    public Cart save(Cart cart) {
//        return this.shoppingCartRepository.save(cart);
//    }
//
    @Override
    public void delete(int shoppingCartId) {
        this.shoppingCartRepository.deleteById(shoppingCartId);
    }
//
//    @Override
//    public ArrayList<Cart> all() {
//        ArrayList<Cart> result = new ArrayList<>();
//        shoppingCartRepository.findAll().forEach(result::add);
//        return result;
//    }
//
//    public Cart findById(int shoppingCartId) {
//        Optional<Cart> shoppingCartOptional = shoppingCartRepository.findById(shoppingCartId);
//        Cart shoppingCartResponse = shoppingCartOptional.get();
//        return shoppingCartResponse;
//    }
//

}
