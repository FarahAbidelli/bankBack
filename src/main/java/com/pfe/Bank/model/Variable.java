package com.pfe.Bank.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="variable",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "code")
        }
)
@JsonIgnoreProperties({"modele"})

public class Variable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String description;
    private Double coefficient;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "modele_id",referencedColumnName = "id")
    private Modele modele;

    @OneToMany(mappedBy = "variable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Score> scores;

    private Responses responseMeaning;

    public Responses getResponseMeaning() {
        return responseMeaning;
    }

    public void setResponseMeaning(Responses responseMeaning) {
        this.responseMeaning = responseMeaning;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
