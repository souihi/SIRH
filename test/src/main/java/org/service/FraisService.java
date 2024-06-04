package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Frais;
import org.repository.FraisRepository;

import java.util.List;

@ApplicationScoped
public class FraisService {

    @Inject
    FraisRepository fraisRepository;

    @Transactional
    public List<Frais> fraisList (){
        return fraisRepository.listAll();
    }
    @Transactional
    public Frais fraisById(long id){
        Frais existingFrais = fraisRepository.findById(id);
        if (existingFrais == null){
            throw new WebApplicationException("Frais not found", 404);
        }
        return existingFrais;
    }

    @Transactional
    public void createFrais(Frais frais){
        fraisRepository.persist(frais);
    }

    @Transactional
    public void udpateFrais(long id, Frais Updatefrais){
        Frais existingFrais = fraisRepository.findById(id);
        if (existingFrais == null){
            throw new WebApplicationException("Frais not found", 404);
        }
        existingFrais.setType(Updatefrais.getType());
        existingFrais.setMontant(Updatefrais.getMontant());
        existingFrais.setDate_frais(Updatefrais.getDate_frais());
        existingFrais.setJustificatif(Updatefrais.getJustificatif());
        existingFrais.setUtilisateur_id(Updatefrais.getUtilisateur_id());
        existingFrais.setValidateur_id(Updatefrais.getValidateur_id());

        fraisRepository.persist(existingFrais);
    }

    @Transactional
    public void deleteFrais(long id){
        Frais existingFrais = fraisRepository.findById(id);
        if (existingFrais == null){
            throw new WebApplicationException("Frais not found", 404);
        }
        fraisRepository.delete(existingFrais);
    }
}
