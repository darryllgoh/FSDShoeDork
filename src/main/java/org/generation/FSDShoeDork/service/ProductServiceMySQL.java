package org.generation.FSDShoeDork.service;

import org.generation.FSDShoeDork.repository.ProductRepository;
import org.generation.FSDShoeDork.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductServiceMySQL implements ProductService {
    //partial setup
    //implement methods from ItemService.java
    //ItemServiceMySQL class will provide all the implementation of all the methods that is provided in the interface.

    //This ItemServiceMySQL class has to depend on another class object to perform CRUD actions (e.g. save, delete, all, findItemById
    //dependent object class is the CRUDRepository class that is provided by Spring boot

    //to perform dependency injection -> access the CRUDRepository class through the ItemRepository interface that we
    // have created

    //ItemRepository is an interface that extends the CRUDRepository
    private final ProductRepository productRepository;

    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation

    public ProductServiceMySQL(@Autowired ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product)
    {
        //since we have done the dependency injection of ItemRepository, now we can call any methods from the
        // CRUDRepository class.
        return this.productRepository.save(product);
    }

    @Override
    public void delete(int productId)
    {
        this.productRepository.deleteById(productId);
    }

    @Override
    public ArrayList<Product> all()
    {
        //@query - query class provided by Springboot. Select * from item
        //repository class provided by Springboot: we do not need to write a single query statement.
        ArrayList<Product> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Product findById(int productId)
    {
        //optional is object that accept either a null (empty) or with items.
        Optional<Product> product = productRepository.findById(productId);
        Product productResponse = product.get();
        return productResponse;
    }



}
