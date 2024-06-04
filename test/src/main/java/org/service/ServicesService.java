package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Services;
import org.repository.ServicesRepository;

import java.util.List;

@ApplicationScoped
public class ServicesService {

    @Inject
    ServicesRepository servicesRepository;

    @Transactional
    public List<Services> serviceList(){
        return servicesRepository.listAll();
    }
    @Transactional
    public Services serviceById(long id){
        Services existingServices = servicesRepository.findById(id);
        if (existingServices == null){
            throw new WebApplicationException("Service not found", 404);
        }
        return existingServices;
    }

    @Transactional
    public void createService( Services services){
        servicesRepository.persist(services);
    }

    @Transactional
    public void updateService(long id, Services updateservice){
        Services existingService = servicesRepository.findById(id);
        if (existingService == null){
            throw new WebApplicationException("Service not found", 404);
        }
        existingService.setNom(updateservice.getNom());
        existingService.setResponsable_id(updateservice.getResponsable_id());

        servicesRepository.persist(existingService);
    }

    @Transactional
    public void deleteService(long id){
        Services existingServices = servicesRepository.findById(id);
        if (existingServices == null){
            throw new WebApplicationException("Service not found", 404);
        }
        servicesRepository.delete(existingServices);
    }
}
