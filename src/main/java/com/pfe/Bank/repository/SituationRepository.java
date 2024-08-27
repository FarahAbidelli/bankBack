package com.pfe.Bank.repository;

import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.model.Role;
import com.pfe.Bank.model.SituationClientProfes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SituationRepository extends JpaRepository<SituationClientProfes, ClientProfes> {
    //Optional<ClientProfes> findById(Long id);
    Optional<SituationClientProfes> findById(Long id);

    List<SituationClientProfes> findByClientId(long clientId);

    List<SituationClientProfes> findByCodeRelation(long codeRelation);

    Optional<SituationClientProfes> findByClientAndDateDeSituation(ClientProfes client, Date dateDeSituation);
}
