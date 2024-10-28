package com.Zosh.projectmanagementsystem.repository;

import com.Zosh.projectmanagementsystem.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription ,Long > {
    Subscription findByUserId(Long userId);
}
