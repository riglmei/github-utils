/**
 * Created by riglesias
 */
package com.riglesias.githubutils.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.riglesias.githubutils.actions.GetUserProfilesAction;
import com.riglesias.githubutils.domain.github.GitHubRepository;
import com.riglesias.githubutils.infrastructure.GitHubRepositoryImpl;

/**
 * Spring Configuration class
 */
@Configuration
public class SpringConfig {



    @Bean
    public GitHubRepository usersRepository(){
        return new GitHubRepositoryImpl();
    }

    @Bean
    public GetUserProfilesAction getUsersAction(GitHubRepository repository){
        return new GetUserProfilesAction(repository);
    }




}
