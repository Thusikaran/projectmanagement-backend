package com.Zosh.projectmanagementsystem.service;

import com.Zosh.projectmanagementsystem.model.PlanType;
import com.Zosh.projectmanagementsystem.model.Subscription;
import com.Zosh.projectmanagementsystem.model.User;

public interface SubscriptionService {
 Subscription createSubscription(User user);

 Subscription getUsersSubscription(Long userId) throws Exception;

 Subscription upgradeSubscription(Long userId, PlanType planType);

 boolean isValid(Subscription subscription);
}
