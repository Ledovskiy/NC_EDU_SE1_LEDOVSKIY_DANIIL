package backend.service;

import backend.entity.Status;
import backend.exeption.NotFoundException;
import backend.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultStatusService implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public DefaultStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status getStatus(Long id) throws NotFoundException {
        Optional<Status> status = statusRepository.findById(id);
        if (status.isPresent()) {
            return status.get();
        } else {
            throw new NotFoundException("Status with id: " + id + " was not found");
        }
    }

    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status updateStatus(Long id, Status status) throws NotFoundException {
        Optional<Status> statusToUpdateOptional = statusRepository.findById(id);
        if (statusToUpdateOptional.isPresent()) {
            Status statusToUpdate = this.updateStatusFields(statusToUpdateOptional.get(), status);
            return statusRepository.save(statusToUpdate);
        } else {
            throw new NotFoundException("Status with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public void deleteStatuses() {
        statusRepository.deleteAll();
    }

    private Status updateStatusFields(Status statusToUpdate, Status newStatus) {
        if (newStatus.getStatus() != null) {
            statusToUpdate.setStatus(newStatus.getStatus());
        }

        return statusToUpdate;
    }
}

