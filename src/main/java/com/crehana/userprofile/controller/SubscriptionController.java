package com.crehana.userprofile.controller;

import com.crehana.userprofile.domain.model.Subscription;
import com.crehana.userprofile.domain.service.SubscriptionService;
import com.crehana.userprofile.resource.SaveSubscriptionResource;
import com.crehana.userprofile.resource.SubscriptionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Subscription", description = "Subscriptions API")
@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscriptions")
    public Page<SubscriptionResource> getAllSubscriptions(Pageable pageable) {
        List<SubscriptionResource> subscriptions = subscriptionService.getAllSubscriptions(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int subscriptionsCount = subscriptions.size();
        return new PageImpl<>(subscriptions, pageable, subscriptionsCount);
    }



    @GetMapping("/subscriptions/{id}")
    public SubscriptionResource getSubscriptionById(@PathVariable(name = "id") Long subscriptionId) {
        return convertToResource(subscriptionService.getSubscriptionById(subscriptionId));
    }

    @PostMapping("/subscriptions")
    public SubscriptionResource createSubscription(@Valid @RequestBody SaveSubscriptionResource resource) {
        return convertToResource(subscriptionService.createSubscription(convertToEntity(resource)));
    }

    @PutMapping("/subscriptions/{id}")
    public SubscriptionResource updateSubscription(@PathVariable(name = "id") Long subscriptionId,
                                 SaveSubscriptionResource resource) {
        return convertToResource(subscriptionService.updateSubscription(subscriptionId, convertToEntity(resource)));
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable(name = "id") Long subscriptionId) {
        return subscriptionService.deleteSubscription(subscriptionId);
    }

    private Subscription convertToEntity(SaveSubscriptionResource resource) {
        return mapper.map(resource, Subscription.class);
    }
    private SubscriptionResource convertToResource(Subscription entity) {
        return mapper.map(entity, SubscriptionResource.class);
    }

}
