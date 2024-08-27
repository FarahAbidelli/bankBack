package com.pfe.Bank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="modele")
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateUpdate;
    private boolean used;
    private boolean updatebale;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextUpdateDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUsedDate;
    private boolean disabled = false;
    private int annee;
    private double minCaValue;
    private double maxCaValue;
    private boolean withFinancialData;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Variable> variables;
    @PrePersist
    public void prePersist() {
        if (!updatebale) {
            nextUpdateDate = null;
        }
        if (!used) {
            lastUsedDate = null;
        }
        if (dateCreation == null) {
            dateCreation = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCreation);
        annee = calendar.get(Calendar.YEAR);
        dateUpdate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        if (!updatebale) {
            nextUpdateDate = null;
        }
        if (!used) {
            lastUsedDate = null;
        }
        dateUpdate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUpdatebale() {
        return updatebale;
    }

    public void setUpdatebale(boolean updatebale) {
        this.updatebale = updatebale;
    }

    public Date getNextUpdateDate() {
        return nextUpdateDate;
    }

    public void setNextUpdateDate(Date nextUpdateDate) {
        this.nextUpdateDate = nextUpdateDate;
    }

    public Date getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(Date lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getMinCaValue() {
        return minCaValue;
    }

    public void setMinCaValue(double minCaValue) {
        this.minCaValue = minCaValue;
    }

    public double getMaxCaValue() {
        return maxCaValue;
    }

    public void setMaxCaValue(double maxCaValue) {
        this.maxCaValue = maxCaValue;
    }

    public boolean isWithFinancialData() {
        return withFinancialData;
    }

    public void setWithFinancialData(boolean withFinancialData) {
        this.withFinancialData = withFinancialData;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

}
