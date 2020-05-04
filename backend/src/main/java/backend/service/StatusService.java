package backend.service;

import backend.entity.Status;
import backend.exeption.NotFoundException;

import java.util.List;

public interface StatusService {

    Status getStatus(Long id) throws NotFoundException;

    Status saveStatus(Status status);

    Status updateStatus(Long id, Status status) throws NotFoundException;

    void deleteStatus(Long id);

    List<Status> getStatuses();

    void deleteStatuses();
}
