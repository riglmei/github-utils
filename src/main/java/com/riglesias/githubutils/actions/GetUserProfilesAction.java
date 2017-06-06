/**
 * Created by riglesias
 */
package com.riglesias.githubutils.actions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.riglesias.githubutils.domain.github.GitHubProfile;
import com.riglesias.githubutils.domain.github.GitHubRepository;


public class GetUserProfilesAction {


    private GitHubRepository usersRepository;

    @Autowired
    public GetUserProfilesAction(GitHubRepository usersRepository){
        this.usersRepository = usersRepository;

    }


    public List<GitHubProfile> getByLocation(final String location, final Optional<Integer> perPage){


        return usersRepository.getUsersByLocation(location, perPage.orElse(usersRepository.getDefaultUsersPerPage()));
    }

}
