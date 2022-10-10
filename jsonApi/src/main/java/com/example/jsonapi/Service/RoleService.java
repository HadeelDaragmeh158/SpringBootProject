package com.example.jsonapi.Service;

import com.example.jsonapi.model.Role;
import com.example.jsonapi.model.User;
import com.example.jsonapi.repository.RoleRepository;
import com.example.jsonapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    public void addRole(Role role){
    roleRepository.save(role );
    }

    public void deleteRole (Long id ){
        roleRepository.deleteById(id);
    }

    public List<Role> getRoles (){
        return roleRepository.findAll();
    }

    public  Optional<Role> findByNameRole (String name ){
        return roleRepository.findByName(name);
    }

    public Optional<Role> findByIdRole(Long id ){
        return roleRepository.findById(id);
    }

    public void UpdateRoles (Long id , Role role ){
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
            roleRepository.save(role);
        }
    }
    public List<Role> findAllRole(){
        return roleRepository.findAll();
    }
    public Optional<User> getUSerByRole(Optional<Role> role){
        Optional<User> user = userRepository.findByRoles(role);
        return user;

    }
    public List<Role> getall ()
    {
        return roleRepository.findAll();
    }
}

//*****************************************
//
//    public List<User> getAllUsersByRoleName(String name, Role role){
//        String roleName = String.valueOf(findByNameRole(name));
//        if (role.getName().equals(name))
//            return role.getUsers();
////        return roleRepository.findAllByName(roleName );
//        return null;
//    }

//    public List<User> getUsersByRoleName(String name){
//        Optional<Role> roleName = (findByNameRole(name));
//        return roleName.get().getUsers();
////        return roleRepository.findAllByName(roleName );
//
//    }
//*****************************************

   /* public Optional<Role> findByUser(User user ) {
        return roleRepository.findByUsers(user);
    }*/