package com.example.jsonapi.repository;

import com.example.jsonapi.model.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamName(String name);
    Optional<Team> findById(Long id);
//USER
    @EntityGraph(attributePaths = {"users"})
    List<Team> findAll();

}
