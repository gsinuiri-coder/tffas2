package com.crehana.userprofile.service;

import com.crehana.userprofile.domain.model.Subscription;
import com.crehana.userprofile.domain.repository.SubscriptionRepository;
import com.crehana.userprofile.domain.repository.UserRepository;
import com.crehana.userprofile.domain.service.SubscriptionService;
import com.crehana.userprofile.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Subscription> getAllSubscriptions(Pageable pageable) {
        return subscriptionRepository.findAll(pageable);
    }

    @Override
    public Page<Subscription> getAllSubscriptionsByUserId(Long userId, Pageable pageable) {
        return userRepository.findById(userId).map(user -> {
            List<Subscription> subscriptions = user.getSubscriptions();
            int subscriptionsCount = subscriptions.size();
            return new PageImpl<>(subscriptions, pageable, subscriptionsCount);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }

    @Override
    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Subscription", "Id", subscriptionId));
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Long subscriptionId, Subscription subscriptionDetails) {
        return subscriptionRepository.findById(subscriptionId).map(subscription -> {
            subscription.setStatus(subscriptionDetails.getStatus());
            return subscriptionRepository.save(subscription);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Subscription", "Id", subscriptionId));
    }

    @Override
    public ResponseEntity<?> deleteSubscription(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).map(subscription -> {
            subscriptionRepository.delete(subscription);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Subscription", "Id", subscriptionId));
    }
}
