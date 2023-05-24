package org.generation.FSDShoeDork.repository;

//This interface will extend from the CrudRepository provided by the SpringBoot framework. We can then access all the
// methods from the CrudRepository object

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.generation.FSDShoeDork.repository.entity.User;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {
    //Nothing for now
    //pass in Item as entity name and integer as id
    //For more complex system/feature, there might be other methods that I need to addon,
    //interface with other relevant classes
    @Query(value= "SELECT id FROM user WHERE username = :username", nativeQuery = true)
    Optional<Integer> findUserIdByUserName(@Param("username") String username);

}