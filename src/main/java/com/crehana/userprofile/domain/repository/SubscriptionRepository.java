package com.crehana.userprofile.domain.repository;

import com.crehana.userprofile.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
