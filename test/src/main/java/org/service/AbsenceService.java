package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Absence;
import org.repository.AbsenceRepository;

import java.util.List;

@ApplicationScoped
public class AbsenceService {

    @Inject
    AbsenceRepository absenceRepository;

    @Transactional
    public List<Absence> absenceList(){
        return absenceRepository.listAll();
    }
    @Transactional
    public Absence absenceById(long id){
        Absence existingAbsence = absenceRepository.findById(id);
        if (existingAbsence == null){
            throw new WebApplicationException("Absence not found", 404);
        }
        return existingAbsence;
    }

    @Transactional
    public void createAbsence(Absence absence){
        absenceRepository.persist(absence);
    }

    @Transactional
    public void updateAbsence(long id, Absence UpdateAbsence){
        Absence existingAbsence = absenceRepository.findById(id);
        if (existingAbsence == null){
            throw new WebApplicationException("Absence not found", 404);
        }
        existingAbsence.setType(UpdateAbsence.getType());
        existingAbsence.setDebut(UpdateAbsence.getDebut());
        existingAbsence.setFin(UpdateAbsence.getFin());
        existingAbsence.setUtilisateur_id(UpdateAbsence.getUtilisateur_id());
        absenceRepository.persist(existingAbsence);
    }

    @Transactional
    public void deleteAbsence(long id){
        Absence existingAbsence = absenceRepository.findById(id);
        if (existingAbsence == null){
            throw new WebApplicationException("Absence not found", 404);
        }
        absenceRepository.delete(existingAbsence);
    }
}
