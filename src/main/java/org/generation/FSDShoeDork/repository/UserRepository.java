package org.generation.FSDShoeDork.repository;

//This interface will extend from the CrudRepository provided by the SpringBoot framework. We can then access all the
// methods from the CrudRepository object

import org.springframework.data.repository.CrudRepository;
import org.generation.FSDShoeDork.repository.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    //Nothing for now
    //pass in Item as entity name and integer as id
    //For more complex system/feature, there might be other methods that I need to addon,
    //interface with other relevant classes

}