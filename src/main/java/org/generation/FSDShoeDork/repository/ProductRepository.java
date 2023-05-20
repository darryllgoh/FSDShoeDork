package org.generation.FSDShoeDork.repository;

//This interface will extends from the CRUDRepository provided by
// Springboot Framework - then we can access all the methods from the CRUDRepository object


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.generation.FSDShoeDork.repository.entity.Product;

import java.util.ArrayList;


public interface ProductRepository extends CrudRepository<Product, Integer> {


    @Query(value = "SELECT * FROM product WHERE category = :category",
        nativeQuery = true)
    ArrayList<Product> getProductByCategory(String category);

}
