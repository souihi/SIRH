package org.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Utilisateur;
import org.repository.UtilisateurRepository;

import java.util.List;

@ApplicationScoped
public class UtilisateurService {
    @Inject
    UtilisateurRepository utilisateurRepository;


    @Transactional
    public List<Utilisateur> utilisateurList(){
        return utilisateurRepository.listAll();
    }

    @Transactional
    public Utilisateur utilisateurListById(long id){
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id);
        if ((existingUtilisateur == null)){
            throw new WebApplicationException("User not found", 404);
        }
        return existingUtilisateur;
    }
    @Transactional
    public void creatUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.persist(utilisateur);
    }

    @Transactional
    public void updateUtilisateur(long id, Utilisateur UpdatedUtilisateur){
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id);
        if ((existingUtilisateur == null)){
            throw new WebApplicationException("User not found", 404);
        }
        existingUtilisateur.setEmail(UpdatedUtilisateur.getEmail());
        existingUtilisateur.setName(UpdatedUtilisateur.getName());
        existingUtilisateur.setUsername(UpdatedUtilisateur.getUsername());
        existingUtilisateur.setRole(UpdatedUtilisateur.getRole());
        existingUtilisateur.setService_id(UpdatedUtilisateur.getService_id());
        utilisateurRepository.persist(existingUtilisateur);
    }

    @Transactional
    public void deleteUtilisateur(long id){
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id);
        if ((existingUtilisateur == null)){
            throw new WebApplicationException("User not found", 404);
        }
        utilisateurRepository.delete(existingUtilisateur);
    }



}
