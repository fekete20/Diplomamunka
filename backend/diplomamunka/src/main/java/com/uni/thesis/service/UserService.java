package com.uni.thesis.service;

import com.uni.thesis.dao.RoleDao;
import com.uni.thesis.dao.UserDao;
import com.uni.thesis.entity.Role;
import com.uni.thesis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User regosterNewUser(User user) {
        Role role = roleDao.findById("User").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }


    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role for an application.");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record.");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("root");
        adminUser.setUserLastName("root");
        adminUser.setUserName("root");
        adminUser.setUserPassword(getEncodedPassword("root"));

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

    }
}
