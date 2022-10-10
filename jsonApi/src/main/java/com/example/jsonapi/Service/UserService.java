package com.example.jsonapi.Service;

import com.example.jsonapi.model.Role;
import com.example.jsonapi.model.User;
import com.example.jsonapi.repository.RoleRepository;
import com.example.jsonapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public UserService(){}

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        userRepository.deleteById(id);
        userRepository.save(user);
    }

//    public void updateUserByName(String name, User user) {
//        if (user.getName() == name) {
//            userRepository.delete(user);
//            userRepository.save(user);
//        }
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }

    public Optional<User> findUserById(Long id ) throws Exception {
        Optional<User> usersWithId = userRepository.findById(id);
        if(usersWithId.isPresent()){
            return usersWithId;
        }
        else{
            throw new Exception("user not found");
        }
    }

    public Optional<User> findUserByRoleId(Long roleID){
        Optional<Role> role =  roleRepository.findById(roleID);
        return userRepository.findByRoles(role);
    }

    Optional<User> findByIdRoles(Long idRole){
        Optional<Role> role =  roleRepository.findById(idRole);
        return userRepository.findByRoles(role);
    }

    public List<Object> findUsersByRole(Optional<Role> role){
        return userRepository.queryUsersByRoles(role);
    }

    public Set<Role> findRoleByUser(User user){
        return user.getRoles();
    }

    public List<Object> findAll(){
        List<Object> allData = new ArrayList<>();
        allData.add(userRepository.findAll());
        return allData;
    }
//[
    public List<Object> alldataInRelation (){
        List<User> allUsers = userRepository.findAll();
        return userDataByGraph(allUsers);
    }

    public List<Object> userDataByGraph (List<User> allUsers){
        List<Object> allData = new ArrayList<>();
        Long id ;
        for ( User users : allUsers
        ) {
            id = users.getId();
            allData.add(userRepository.findUserIdJoin(id));
        }
        return  allData;
    }
//]

    public List<User>allRelationsJoin(){return userRepository.allUserJoin();}
    public List<User> search (String name ){
        return userRepository.searchByName(name);
    }

//    public gitAll
}


//*************************************************
//]
//    public List<Object>  findusersAndRoleId(Long id){
//        Optional<Role> role = roleRepository.findById(id);
//        return userRepository.finduserIdJPQL(role.get().getId());
//    }

//    public List<User> search (String name ){
//        return userRepository.searchByName(name);
//    }
//*************************************************
//    private static Map<Long, User> userMap = new HashMap<>();  //TODO///// I DONT KNOW WHAT IS IT,  ACTUALLY
//    static {
//        User honey = new User();                               //TODO///// WHAT IS STATIC
//        honey.setName("Honey");                                //TODO//// I THINK IN THIS WAY I ADD DATA MANUALLY !!!!!!!!!!  IS THIS WRITE
//        userMap.put(honey.getId(), honey);
//
//        User almond = new User();
//        almond.setName("Almond");                             ////// **********************************************
//        userMap.put(almond.getId(), almond);                  ////// **********************************************
//    }
//***************************************************
//    public List<User> getAllUser(){
//        return (List<User>) userRepository.findAll();
//    }
//    public void addUser(User user){
//        userRepository.save(user);
//    }
//***************************************************
//public List<User> findUSerByName(String name){
//        List<User> usersByName = new ArrayList<>();
//        usersByName.add(userRepository.findAllByName(name));
//}
//TODO
//    <S extends User> S save(S entity){
//        userRepository.save(entity);
//            return entity;
//        }
//***************************************************