package com.pfe.Bank.repository;

import com.pfe.Bank.model.Client;
import com.pfe.Bank.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    //Optional<Client> findByCodeRelationAndIdNat(long codeRelation, String idNat);

    //Client findByCodeRelation(Long codeRelation);
    Optional<Client> findByCodeRelationAndIdNat(long codeRelation, String idNat);
    Optional<Client> findByCodeRelation(long codeRelation);
}
