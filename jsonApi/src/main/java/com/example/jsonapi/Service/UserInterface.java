package com.example.jsonapi.Service;

import com.example.jsonapi.model.User;

import java.util.Collection;

public interface UserInterface {
    public abstract void createUser (User user);
    public abstract void updateUser(Long id , User user );
    public abstract void deleteUser (Long Id);
    public abstract Collection<User> getUser(); // is collection like list ????????????

}
