package com.nchdatta.SchoolManagementSystem.services.impl;

import com.nchdatta.SchoolManagementSystem.entities.User;
import com.nchdatta.SchoolManagementSystem.enums.UserRole;
import com.nchdatta.SchoolManagementSystem.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {
    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    Create Admin User if not exists
    @PostConstruct
    public void createAdmin() {
        try {
            User admin = userRepository.findByUsername("admin");

            if (admin == null) {
                admin = new User();
                BCryptPasswordEncoder hashedPassword = new BCryptPasswordEncoder();

                admin.setUsername("admin");
                admin.setPassword(hashedPassword.encode("admin"));
                admin.setEmail("admin@gmail.com");
                admin.setName("Admin");
                admin.setRole(UserRole.ADMIN.name());

                userRepository.save(admin);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
