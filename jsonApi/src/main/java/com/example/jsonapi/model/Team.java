package com.example.jsonapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teamTable")
public class Team {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String teamName;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    public Team(Team team) {
    }
}
