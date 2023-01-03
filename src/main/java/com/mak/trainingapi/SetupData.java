package com.mak.trainingapi;

import com.mak.trainingapi.model.Role;
import com.mak.trainingapi.model.User;
import com.mak.trainingapi.repository.RoleRepository;
import com.mak.trainingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

public class SetupData implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        createRoleIfNotFound("ROLE_USER");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElse(createRoleIfNotFound("ROLE_ADMIN"));
        User user = new User();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(adminRole);
        user.setUsername("Admin");
        user.setPassword(passwordEncoder.encode("AppAdmin!1"));
        user.setRoles(roleSet);
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name){
        Role role = roleRepository.findByName(name).orElse(null);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
