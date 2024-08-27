package com.pfe.Bank.repository;

import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.Client;
import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.model.Menu;
import com.pfe.Bank.model.SituationClientProfes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientProfesRepository extends JpaRepository<ClientProfes,String> {
    Optional<ClientProfes> findByCodeRelation(long codeRelation);
    Optional<ClientProfes> findById(Long id);
    Optional<Client> findByCodeRelationAndIdNat(long codeRelation, String idNat);
    Client findByCodeRelation(Long codeRelation);
}
