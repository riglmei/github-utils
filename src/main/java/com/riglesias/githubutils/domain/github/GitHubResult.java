/**
 * Created by riglesias
 */
package com.riglesias.githubutils.domain.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * Class representing the result of a query to the
 * Git Hub REST API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubResult{

    int total_count;

    boolean incomplete_results;

    List<GitHubProfile> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<GitHubProfile> getItems() {
        return items;
    }

    public void setItems(List<GitHubProfile> items) {
        this.items = items;
    }
}
