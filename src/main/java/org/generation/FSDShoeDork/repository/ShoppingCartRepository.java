package org.generation.FSDShoeDork.repository;

import org.generation.FSDShoeDork.repository.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ShoppingCartRepository extends CrudRepository<Cart, Integer> {

    @Query(value = "SELECT * FROM Cart WHERE User_id = :userId",
            nativeQuery = true)
    ArrayList<Cart> findCartByUserId(@Param("userId") Integer userId);
}
