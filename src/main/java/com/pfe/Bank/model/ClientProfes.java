package com.pfe.Bank.model;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("profes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientProfes extends Client{


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRNE;
    private String secteurActivite;
    private String perimetreActivite;
    private double chiffreAffaire;
    private String segment;
    private String gouvernorat;
    private String denominationSociale;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Notation> notations;

    @Builder
    public ClientProfes(String denominationSociale, Date dateRNE, String secteurActivite, String perimetreActivite, double chiffreAffaire, String segment, String gouvernorat , long id, long codeRelation, String idNat, String codeRelationFlexcube, String identifiantProspect, String nom, String profession, String adresse, String agence, String ville, String region, Date dateNaissance, Date dateDebutRelation, String autre) {
        super();
        this.dateRNE = dateRNE;
        this.denominationSociale=denominationSociale;
        this.secteurActivite = secteurActivite;
        this.perimetreActivite = perimetreActivite;
        this.chiffreAffaire = chiffreAffaire;
        this.segment = segment;
        this.gouvernorat = gouvernorat;
        super.setIdNat(idNat);
        super.setCodeRelationFlexcube(codeRelationFlexcube);
        this.setCodeRelation(codeRelation);
        super.setIdentifiantProspect(identifiantProspect);
        super.setNom(nom);
        super.setProfession(profession);
        super.setAdresse(adresse);
        super.setAgence(agence);
        super.setVille(ville);
        super.setDateNaissance(dateNaissance);
        super.setDateDebutRelation(dateDebutRelation);
        super.setAutre(autre);
        /*
        super.setDateCreate(dateCreate);
        super.setDateUpdate(dateUpdate);
        super.setIsfull(isfull);*/
        super.setId(id);
    }

    public Date getDateRNE() {
        return dateRNE;
    }

    public void setDateRNE(Date dateRNE) {
        this.dateRNE = dateRNE;
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

    public List<Notation> getNotations() {
        return notations;
    }

    public void setNotations(List<Notation> notations) {
        this.notations = notations;
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




