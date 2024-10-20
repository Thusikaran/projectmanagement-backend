package com.Zosh.projectmanagementsystem.repository;

import com.Zosh.projectmanagementsystem.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Long> {
}
