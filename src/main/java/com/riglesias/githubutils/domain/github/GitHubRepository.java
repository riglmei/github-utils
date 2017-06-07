/**
 * Created by riglesias
 */
package com.riglesias.githubutils.domain.github;

import java.util.List;

/**
 * Repository to get get the information of
 * GitHubUser
 */
public interface GitHubRepository {


    /**
     *
     * Gets a list of Github Users that
     * have the given location in their profile description.
     *
     * The result will be obtained ordered by the number of repositories
     * of each user.
     *
     * @param location - name of the location to search
     * @return
     */
    List<GitHubProfile> getUsersByLocation(final String location, final int byPage);

    /**
     * Establish the default number of users by page in a query to the REST API
     *
     * @return
     */
    int getDefaultUsersPerPage();


    /**
     * Gets the profiles of users that matches a given user name
     * @param login - user name to search
     * @return
     */
    List<GitHubProfile> getUsersUserLogin(final String login,final  int perPage);

}
