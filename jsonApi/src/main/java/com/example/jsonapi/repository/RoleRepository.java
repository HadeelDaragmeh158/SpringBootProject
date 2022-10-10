package com.example.jsonapi.repository;

import com.example.jsonapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName (String name );   // @Query ("SELECT h FROM Role WHERE h.name = ?1") Role findByName(String name);
    Optional<Role> findById(Long id );          // @Query ("SELECT h FROM Role WHERE h.id = ?1") Role findByName(Long id);

}
