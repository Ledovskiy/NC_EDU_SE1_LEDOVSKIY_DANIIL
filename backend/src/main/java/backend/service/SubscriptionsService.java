package backend.service;

import backend.entity.Subscriptions;
import backend.exeption.NotFoundException;

import java.util.List;

public interface SubscriptionsService {

    Subscriptions getSubscription(Long id) throws NotFoundException;

    Subscriptions saveSubscription(Subscriptions subscriptions);

    Subscriptions updateSubscription(Long id, Subscriptions subscriptions) throws NotFoundException;

    void deleteSubscription(Long id);

    List<Subscriptions> getSubscriptions();

    void deleteSubscriptions();
}
