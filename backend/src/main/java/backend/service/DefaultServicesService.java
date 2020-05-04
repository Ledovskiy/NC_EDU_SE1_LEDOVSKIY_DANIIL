package backend.service;

import backend.entity.Services;
import backend.exeption.NotFoundException;
import backend.repository.ServicesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultServicesService implements ServicesService {

    private final ServicesRepository servicesRepository;

    @Autowired
    public DefaultServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public Services getService(Long id) throws NotFoundException {
        Optional<Services> Services = servicesRepository.findById(id);
        if (Services.isPresent()) {
            return Services.get();
        } else {
            throw new NotFoundException("Services with id: " + id + " was not found");
        }
    }

    @Override
    public Services saveService(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public Services updateService(Long id, Services services) throws NotFoundException {
        Optional<Services> servicesToUpdateOptional = servicesRepository.findById(id);
        if (servicesToUpdateOptional.isPresent()) {
            Services servicesToUpdate = this.updateServicesFields(servicesToUpdateOptional.get(), services);
            return servicesRepository.save(servicesToUpdate);
        } else {
            throw new NotFoundException("Services with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public List<Services> getServices() {
        return servicesRepository.findAll();
    }

    @Override
    public void deleteServices() {
        servicesRepository.deleteAll();
    }

    private Services updateServicesFields(Services ServicesToUpdate, Services newServices) {
        if (newServices.getServiceName() != null) {
            ServicesToUpdate.setServiceName(newServices.getServiceName());
        }
        if (newServices.getInformation() != null) {
            ServicesToUpdate.setInformation(newServices.getInformation());
        }
        if (newServices.getPrice() != null) {
            ServicesToUpdate.setPrice(newServices.getPrice());
        }

        return ServicesToUpdate;
    }
}

