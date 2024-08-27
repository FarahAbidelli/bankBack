package com.pfe.Bank.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double score;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "variable_id", nullable = false)
    private Variable variable;
    @Transient
    private Long variableId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    /*public void setValeur(String valeur) {
        this.valeur = valeur;
    }*/

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
