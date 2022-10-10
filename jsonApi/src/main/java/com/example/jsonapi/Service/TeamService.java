package com.example.jsonapi.Service;


import com.example.jsonapi.model.Team;
import com.example.jsonapi.model.User;
import com.example.jsonapi.repository.TeamRepository;
import com.example.jsonapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    public TeamService(){}

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Team> getbyName(String name){
        return teamRepository.findByTeamName(name );
    }

    public Optional<Team> getById(Long id){
        return teamRepository.findById(id);
    }

    public void deleteTeam (Long id ){
        teamRepository.deleteById(id);
    }

    public void createTeam (Team team){
            teamRepository.save(team);
    }

    public void updateTeam (Long id , Team team){
        if (teamRepository.findById(id).isPresent()) {
            teamRepository.deleteById(id);
            teamRepository.save(team);
        }
    }

    public List<Team> findAllTeams(){ return teamRepository.findAll();}
//NOT COMPLETED YET
//I need to set user into Team ?????
    public void addUSerToTeam (Long teamId, Long userID){
        if (teamRepository.findById(teamId).isPresent()) {

        }
      //teamRepository.deleteById(id);
      //teamRepository.save(team);
    }


}
