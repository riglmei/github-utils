/**
 * Created by riglesias
 */
package com.riglesias.githubutils.domain.github;

import java.util.List;

public interface GitHubRepository {


    /**
     *
     * Gets a list of github that
     * have the given location in their profile description.
     *
     * The result will be obtained ordered by the number of repositories
     * of each user.
     *
     * @param location - name of the location to search
     * @return
     */
    List<GitHubProfile> getUsersByLocation(String location, int byPage);

    int getDefaultUsersPerPage();

}
