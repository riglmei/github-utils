/**
 * Created by riglesias
 */
package com.riglesias.githubutils.infrastructure;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.riglesias.githubutils.domain.github.GitHubProfile;
import com.riglesias.githubutils.domain.github.GitHubRepository;

import config.SpringConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigTest.class })
public class GitHubRepositoryTest {

    public static final String CITY_WITH_USERS = "Barcelona";
    public static final int ZERO = 0;
    public static final String INVENTED_CITY = "Sijueiro";
    public static final int BY_PAGE = 20;

    @Autowired
    private GitHubRepository gitHubRepository;

    @Test
    public void testThereAreResults() {

        final List<GitHubProfile> usersByLocation = gitHubRepository.getUsersByLocation(CITY_WITH_USERS, BY_PAGE);
        assertThat(usersByLocation, notNullValue());
        assertThat(usersByLocation.size(), Matchers.greaterThan(ZERO));

    }


    @Test
    public void testNoResults() {

        final List<GitHubProfile> usersByLocation = gitHubRepository.getUsersByLocation(INVENTED_CITY,BY_PAGE);
        assertThat(usersByLocation, notNullValue());
        assertThat(usersByLocation.size(), equalTo(ZERO));

    }


}
