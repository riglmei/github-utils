/**
 * Created by riglesias
 */
package com.riglesias.githubutils.infrastructure;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.riglesias.githubutils.domain.github.GitHubResult;
import com.riglesias.githubutils.domain.github.GitHubProfile;
import com.riglesias.githubutils.domain.github.GitHubRepository;


/**
 * Implementation of the interface with a JerseyClient
 * that queries the public REST API of Github
 */
public class GitHubRepositoryImpl implements GitHubRepository {


    public static final String URL_GET_USERS = "https://api.github.com/search/users";
    public static final String PARAM_QUERY = "q";
    public static final String SORT = "sort";
    public static final String SORT_TYPE_REPOSITORIES = "repositories";
    public static final String PARAM_PER_PAGE = "per_page";
    public static final int DEFAULT_BY_PAGE = 30;

    @Override
    public List<GitHubProfile> getUsersByLocation(final String location, int perPage) {


        Client client = ClientBuilder.newClient();

        String paramQuery = buildQuery(location);
        WebTarget webTarget = client.target(URL_GET_USERS)
                .queryParam(PARAM_QUERY, paramQuery)
                .queryParam(SORT, SORT_TYPE_REPOSITORIES)
                .queryParam(PARAM_PER_PAGE,perPage);
        final Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        final GitHubResult result = response.readEntity(GitHubResult.class);
        return result.getItems();

    }


    @Override
    public int getDefaultUsersPerPage() {
        return DEFAULT_BY_PAGE;
    }

    /**
     * Constructs the value of the parameter 'q' used
     * in Users search, according to the Github API format
     *
     * @param location -
     * @return
     */
    private String buildQuery(String location){
        StringBuilder builder = new StringBuilder("location:");
        builder.append(location);
        builder.append(" type:user");
        //https://api.github.com/search/users?q=location:BarcelonA+type:user&sort=repositories
        return new String(builder.toString().getBytes(), StandardCharsets.UTF_8);
    }
}
