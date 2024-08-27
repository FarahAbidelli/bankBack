package com.pfe.Bank.service;

import lombok.*;
import com.opencsv.bean.CsvBindByName;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCsvRepresentation {

    @CsvBindByName(column="code_relation_atlas")
    private long codeRelation;
    @CsvBindByName(column = "identifiant_national")
    private String idNat;
    @CsvBindByName(column = "code_relation_flexcube")
    private String codeRelationFlexcube;
    @CsvBindByName(column = "identifiant_prospect")
    private String identifiantProspect;
    @CsvBindByName(column = "profession")
    private  String profession;
    @CsvBindByName(column = "adresse")
    private String adresse;
    @CsvBindByName(column = "agence")
    private String agence;
    @CsvBindByName(column = "ville")
    private String ville;
    @CsvBindByName(column = "region")
    private String region;
    @CsvBindByName(column = "date_naissance")
    private String dateNaissance;
    @CsvBindByName(column = "date_debut_relation")
    private String dateDebutRelation;
    @CsvBindByName(column = "autre_information")
    private String autre;
    @CsvBindByName(column = "date_RNE")
    private String dateRNE;
    @CsvBindByName(column = "secteur_activite")
    private String secteurActivite;
    @CsvBindByName(column = "perimetre_activite")
    private String perimetreActivite;
    @CsvBindByName(column = "dernier_chiffre_affaire")
    private double chiffreAffaire;
    @CsvBindByName(column = "segment")
    private String segment;
    @CsvBindByName(column = "gouvernorat")
    private String gouvernorat;
    @CsvBindByName(column = "denomination_sociale")
    private String denominationSociale;



    public long getCodeRelation() {
        return codeRelation;
    }

    public void setCodeRelation(long codeRelation) {
        this.codeRelation = codeRelation;
    }

    public String getIdNat() {
        return idNat;
    }

    public void setIdNat(String idNat) {
        this.idNat = idNat;
    }

    public String getCodeRelationFlexcube() {
        return codeRelationFlexcube;
    }

    public void setCodeRelationFlexcube(String codeRelationFlexcube) {
        this.codeRelationFlexcube = codeRelationFlexcube;
    }

    public String getIdentifiantProspect() {
        return identifiantProspect;
    }

    public void setIdentifiantProspect(String identifiantProspect) {
        this.identifiantProspect = identifiantProspect;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateDebutRelation(String dateDebutRelation) {
        this.dateDebutRelation = dateDebutRelation;
    }

    public void setDateRNE(String dateRNE) {
        this.dateRNE = dateRNE;
    }

    public String getDateDebutRelation() {
        return dateDebutRelation;
    }


    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getDateRNE() {
        return dateRNE;
    }


    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getPerimetreActivite() {
        return perimetreActivite;
    }

    public void setPerimetreActivite(String perimetreActivite) {
        this.perimetreActivite = perimetreActivite;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDenominationSociale() {
        return denominationSociale;
    }

    public void setDenominationSociale(String denominationSociale) {
        this.denominationSociale = denominationSociale;
    }
}
