/**
 * Created by riglesias
 */
package com.riglesias.githubutils.domain.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class representing the information of a GitHub user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubProfile {


    private String login;

    private String url;

    private String html_url;

    private String repos_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
}
