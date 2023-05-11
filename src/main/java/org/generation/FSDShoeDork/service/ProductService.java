package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.entity.Product;

import java.util.ArrayList;

public interface ProductService {
    //save method is for 2 purposes - Create new item & Update existing item
    Product save(Product item);


    //Delete item from database - based on item Id
    void delete(int productId);


    //Read all item from database
    ArrayList<Product> all();


    //Read an item from database - based on item Id
    Product findById(int productId);
}
