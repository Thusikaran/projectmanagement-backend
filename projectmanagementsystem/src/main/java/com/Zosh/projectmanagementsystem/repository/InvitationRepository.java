package com.Zosh.projectmanagementsystem.repository;

import com.Zosh.projectmanagementsystem.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository {
    Invitation findByToken(String token);

    Invitation findByEmail(String userEmail);
}
