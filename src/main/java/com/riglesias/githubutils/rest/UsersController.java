/**
 * Created by riglesias
 */
package com.riglesias.githubutils.rest;

import com.riglesias.githubutils.domain.github.GitHubProfile;
import com.riglesias.githubutils.actions.GetUserProfilesAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class UsersController {

    public static final String LOCATION = "location";
    public static final String PARAM_PER_PAGE = "per_page";

    private GetUserProfilesAction getUsersAction;

    @Autowired
    public UsersController(GetUserProfilesAction action) {
        this.getUsersAction = action;
    }

    /**
     * Health check endpoint
     * 
     * @return
     */
    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }


    @RequestMapping(path = "/users/location/{location}", method = RequestMethod.GET)
    public ResponseEntity<List<GitHubProfile>> getUsersByLocationAndResultsByPage(
            @PathVariable(LOCATION) final String location,
            @RequestParam(value = PARAM_PER_PAGE, required = false)  Integer perPage) {

        final List<GitHubProfile> byLocation = getUsersAction.getByLocation(location, Optional.ofNullable(perPage));
        return new ResponseEntity<>(byLocation, HttpStatus.OK);
    }

}
