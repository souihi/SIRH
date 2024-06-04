package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Conge;
import org.jboss.logmanager.handlers.UdpOutputStream;
import org.repository.CongeRepository;
import java.util.List;

@ApplicationScoped
public class CongeService {

    @Inject
    CongeRepository congeRepository;

    @Transactional
    public List<Conge> congeList(){
        return congeRepository.listAll();
    }

    @Transactional
    public Conge congeById(long id){
        Conge existingConge = congeRepository.findById(id);
        if (existingConge == null){
            throw new WebApplicationException("Conge not found", 404);
        }
        return existingConge;
    }

    @Transactional
    public void createConge(Conge conge){
        congeRepository.persist(conge);
    }

    @Transactional
    public void updateConge(long id, Conge UpdateConge){
        Conge existingConge = congeRepository.findById(id);
        if (existingConge == null){
            throw new WebApplicationException("Conge not found", 404);
        }
        existingConge.setDate_demande(UpdateConge.getDate_demande());
        existingConge.setDate_debut(UpdateConge.getDate_debut());
        existingConge.setDate_fin(UpdateConge.getDate_fin());
        existingConge.setUtilisateur_id(UpdateConge.getUtilisateur_id());
        existingConge.setValidateur_id(UpdateConge.getValidateur_id());
        congeRepository.persist(existingConge);
    }

    @Transactional
    public void deleteConge(long id){
        Conge existingConge = congeRepository.findById(id);
        if (existingConge == null){
            throw new WebApplicationException("Conge not found", 404);
        }
        congeRepository.delete(existingConge);
    }

}
