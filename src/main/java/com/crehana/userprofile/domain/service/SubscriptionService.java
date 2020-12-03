package com.crehana.userprofile.domain.service;

import com.crehana.userprofile.domain.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    Page<Subscription> getAllSubscriptions(Pageable pageable);
    Page<Subscription> getAllSubscriptionsByUserId(Long userId, Pageable pageable);
    Subscription getSubscriptionById(Long subscriptionId);
    Subscription createSubscription(Subscription subscription);
    Subscription updateSubscription(Long subscriptionId, Subscription subscriptionDetails);
    ResponseEntity<?> deleteSubscription(Long subscriptionId);
}
