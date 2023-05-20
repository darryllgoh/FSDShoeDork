//package org.generation.FSDShoeDork.service;
//
//import org.generation.FSDShoeDork.repository.ShoppingCartRepository;
//
//import org.generation.FSDShoeDork.repository.entity.CartEntry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class ShoppingCartMySQL implements ShoppingCartService {
//
//    private final ShoppingCartRepository shoppingCartRepository;
//
//    public ShoppingCartMySQL(@Autowired ShoppingCartRepository shoppingCartRepository) {
//        this.shoppingCartRepository = shoppingCartRepository;
//
//    }
//
//    public CartEntry save(CartEntry cartEntry) {
//        return this.shoppingCartRepository.save(cartEntry);
//    }
//
//    @Override
//    public void delete(int shoppingCartId) {
//        this.shoppingCartRepository.deleteById(shoppingCartId);
//    }
//
//    @Override
//    public ArrayList<CartEntry> all() {
//        ArrayList<CartEntry> result = new ArrayList<>();
//        shoppingCartRepository.findAll().forEach(result::add);
//        return result;
//    }
//
//    public CartEntry findById(int shoppingCartId) {
//        Optional<CartEntry> shoppingCartOptional = shoppingCartRepository.findById(shoppingCartId);
//        CartEntry shoppingCartResponse = shoppingCartOptional.get();
//        return shoppingCartResponse;
//    }
//
//    @Override
//    public ArrayList<CartEntry> findAllByUserId(Integer userId) {
//
//        //ArrayList<CartEntry> result = shoppingCartRepository.findAllByUserId(userId);
//        //return result;
//    }
//    //ArrayList<CartEntry> findAllByUserId(userId);
//
//}
