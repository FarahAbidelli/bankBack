package com.pfe.Bank.service;

import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.form.ModeleForm;
import com.pfe.Bank.model.Modele;

import java.util.List;

public interface ModeleService {
    List<Modele> getAllModele();

    public Modele addModele(ModeleForm form) throws MissingEntity;

    Modele getModeleById(long id) throws MissingEntity;

    public Modele updateModele(Long id, ModeleForm form) throws MissingEntity;

    void deleteModele(Long id) throws MissingEntity;

    public List<Modele> getModelesToBeSoftDisabled();

    public List<Modele> getModelesSoftDisabled();

    public List<Modele> getModelesUsed();

    public List<Modele> getModelesNotUsed();

    public void restoreModele(Long id) throws MissingEntity;

    public List<Modele> searchByNameAndAnnee(String name, int annee);

    double calculateModelPonderation(Long id);
}

