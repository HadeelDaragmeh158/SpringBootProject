package com.example.jsonapi.model;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    public User(){

    }

    public User(String name, String email, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void deleteRole (Long roleId){
        Role role = this.roles.stream().filter(r -> r.getId()== roleId).findFirst().orElse(null);
        if (role != null ){
            this.roles.remove(role);
        }
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "ImmutableLiveSteam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discription='" + email + '\'' +
                '}';
    }
}
