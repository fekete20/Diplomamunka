package com.uni.thesis.service;

import com.uni.thesis.dao.UserDao;
import com.uni.thesis.entity.JwtRequest;
import com.uni.thesis.entity.JwtResponse;
import com.uni.thesis.entity.User;
import com.uni.thesis.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findById(username).get();

        if(user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("Username is not valid!");
        }
    }

    private Set getAuthorities(User user) {
        Set authorities = new HashSet();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUserName();
        String password = jwtRequest.getUserPassword();

        authenticate(username, password);
        final UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findById(username).get();

        return new JwtResponse(user, newGeneratedToken);

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException disabledException) {
            throw new Exception("User is disabled!");
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Bad credentials from user!");
        }

    }
}
