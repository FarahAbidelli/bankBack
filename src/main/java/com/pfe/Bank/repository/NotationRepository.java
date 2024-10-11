package com.pfe.Bank.repository;

import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.model.Notation;
import com.pfe.Bank.model.ResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotationRepository extends JpaRepository <Notation,Long> {
    List<Notation> findByStatus(ResponseStatus responseStatus);
    Optional<Notation> findById(Long id);

}
