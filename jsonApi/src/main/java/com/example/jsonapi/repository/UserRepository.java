package com.example.jsonapi.repository;

//import org.springframework.data.jpa.repository.JpaRepository;  // ic an use it but let me start with crud
import com.example.jsonapi.model.Role;
import com.example.jsonapi.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User , Long> {

    Optional<User> findById(Long id);
    Optional<User> findByRoles(Optional<Role> role);
    List<Object>queryUsersByRoles(Optional<Role> role);
//ROLE
    @EntityGraph(attributePaths = {"roles"})
    List<User> findAll(); // in lazy it will give all data

    @Query("select u from User u join fetch u.roles r") // where r.id=3
    List<User> allUserJoin();

    @Query("select u  from User u  join Role n on u.id = :id ")
     List<Object>  findUserIdJoin(Long id); /// it give me join data

    @Query("select u  from User u  left join Role n on  u.id = :id ")
    List<Object> findUserIdLeft(Long id);

    @Query("select u  from User u  inner join Role n on u.id = :id ") //where u.id is not null or n.id is not null
    List<Object>  findUserIdInner(Long id);

//USER
     Optional<User> findAllByName(String name );

     List<User> searchByName(String name );
}


//    @Query("select name from User")
//    List<User> findMainUser();


//    @Query("select u from User u where u.id=?1")
//    User findAllById(Long id );

//     this query from jpa , we use it jpql
//    @Query("select u from User u where u.id=:userID")
//    User findAllById2(@Param("userID") Long id );

//     native query
//    @Query(value = "select * from userTable  where id=:userID",nativeQuery = true)
//    User findAllById3(@Param("userID") Long id );
//}
//    Optional<User> findByTeams(Team team );
//    List<User> findAll();

//@Query("select c from Customer c inner join c.orders o where c.id = :customerId and o.id = :orderId")
//Optional<Customer> findCustomerByOrderId(long orderId, long customerId);
//    Collection<Object>streamDistinctFirstBy = new ArrayList<>();

//    User fiById(Long id );
//    Optional<User> fiById(Long id );


    // delete/1 @PathVariable
    //delete?id-1 this is @PathParam
    // what is the diferente bettween pathvariable and path param
    // in path param i can put id = 1 / name = "hadeel"
    // i can drop the record but in path variable i cannot forget any variable and i need to put them by the order

    // what i can use with queries ?? else List there is alot of ways to save or add the result from query than List
//    @Override
//    <S extends User> S save(S entity); // To save Entity
//    Optional<User> findById();         // Return Entity identied by given ID  it will cover this entity in OBJECT
//    Iterable<User> findById2();        // Return Entity identied by given ID  it will cover this entity in LIST
//    List<User> findAll();              // Return All Entities
//    long count();                      // Return the nimber of Entity
//    @Override
//    boolean existsById(Long id); // is this entity exist by ID

