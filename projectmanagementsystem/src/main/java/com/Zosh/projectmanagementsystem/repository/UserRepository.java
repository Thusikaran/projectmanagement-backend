package com.Zosh.projectmanagementsystem.repository;

import com.Zosh.projectmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
