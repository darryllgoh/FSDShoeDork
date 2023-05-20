//package org.generation.FSDShoeDork.repository;
//
//import org.generation.FSDShoeDork.repository.entity.CartEntry;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.ArrayList;
//
//public interface ShoppingCartRepository extends CrudRepository<CartEntry, Integer> {
//
//    @Query(value = "SELECT * FROM shoppingcart WHERE user_id = :userId",
//            nativeQuery = true)
//    ArrayList<CartEntry> findAllByUserId(Integer userId);
//}
