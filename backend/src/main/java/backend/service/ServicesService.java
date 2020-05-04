package backend.service;

import backend.entity.Services;
import backend.exeption.NotFoundException;

import java.util.List;

public interface ServicesService {

    Services getService(Long id) throws NotFoundException;

    Services saveService(Services services);

    Services updateService(Long id, Services services) throws NotFoundException;

    void deleteService(Long id);

    List<Services> getServices();

    void deleteServices();
}
