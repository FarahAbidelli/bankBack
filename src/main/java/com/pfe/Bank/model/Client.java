package com.pfe.Bank.model;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name="code_relation")
    private long codeRelation;
    @Column (name="id_nat")
    private String idNat;
    private String codeRelationFlexcube;
    private String identifiantProspect;
    private  String nom;
    private  String profession;
    private String adresse;
    private String agence;
    private String ville;
    private String region;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebutRelation;
    @Column(name="autre_information",columnDefinition="BLOB")
    @Lob
    private String autre;
    private LocalDateTime dateCreate;
    private  LocalDateTime dateUpdate;
    private boolean isfull;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDebutRelation() {
        return dateDebutRelation;
    }

    public void setDateDebutRelation(Date dateDebutRelation) {
        this.dateDebutRelation = dateDebutRelation;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public boolean isIsfull() {
        return isfull;
    }

    public void setIsfull(boolean isfull) {
        this.isfull = isfull;
    }
}
