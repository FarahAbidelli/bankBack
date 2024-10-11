package com.pfe.Bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ResponseStatus status;
    private double note;

    @OneToMany(mappedBy = "notation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Response> responses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ClientProfes client;

    public ClientProfes getClient() {
        return client;
    }

    public void setClient(ClientProfes client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public double getNote() {
        return note;
    }

    public List<Response> getResponses() {
        return responses;
    }

}