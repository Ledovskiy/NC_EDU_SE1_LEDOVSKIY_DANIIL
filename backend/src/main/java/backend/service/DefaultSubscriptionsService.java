package backend.service;

import backend.entity.Subscriptions;
import backend.exeption.NotFoundException;
import backend.repository.SubscriptionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultSubscriptionsService implements SubscriptionsService {

    private final SubscriptionsRepository subscriptionsRepository;

    @Autowired
    public DefaultSubscriptionsService(SubscriptionsRepository subscriptionsRepository) {
        this.subscriptionsRepository = subscriptionsRepository;
    }

    @Override
    public Subscriptions getSubscription(Long id) throws NotFoundException {
        Optional<Subscriptions> subscriptions = subscriptionsRepository.findById(id);
        if (subscriptions.isPresent()) {
            return subscriptions.get();
        } else {
            throw new NotFoundException("Subscriptions with id: " + id + " was not found");
        }
    }

    @Override
    public Subscriptions saveSubscription(Subscriptions subscriptions) {
        return subscriptionsRepository.save(subscriptions);
    }

    @Override
    public Subscriptions updateSubscription(Long id, Subscriptions subscriptions) throws NotFoundException {
        Optional<Subscriptions> subscriptionsToUpdateOptional = subscriptionsRepository.findById(id);
        if (subscriptionsToUpdateOptional.isPresent()) {
            Subscriptions subscriptionsToUpdate = this.updateSubscriptionsFields(subscriptionsToUpdateOptional.get(), subscriptions);
            return subscriptionsRepository.save(subscriptionsToUpdate);
        } else {
            throw new NotFoundException("Subscriptions with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionsRepository.deleteById(id);
    }

    @Override
    public List<Subscriptions> getSubscriptions() {
        return subscriptionsRepository.findAll();
    }

    @Override
    public void deleteSubscriptions() {
        subscriptionsRepository.deleteAll();
    }

    private Subscriptions updateSubscriptionsFields(Subscriptions subscriptionsToUpdate, Subscriptions newSubscriptions) {
        if (newSubscriptions.getSubscribeDays() != null) {
            subscriptionsToUpdate.setSubscribeDays(newSubscriptions.getSubscribeDays());
        }

        return subscriptionsToUpdate;
    }
}

