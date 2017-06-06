/**
 * Created by riglesias
 */
package com.riglesias.githubutils.domain.users;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersService extends UserDetailsService {


    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
