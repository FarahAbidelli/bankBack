package com.pfe.Bank.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.pfe.Bank.dto.SituationDto;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.model.SituationClientProfes;
import com.pfe.Bank.repository.ClientProfesRepository;
import com.pfe.Bank.repository.FinanceRepository;
import com.pfe.Bank.repository.SituationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SituationClientService {
    @Autowired
    private SituationRepository repository;

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private ClientProfesRepository clientProfesRepository;

    public List<SituationClientProfes> getAllSituation() {
        return repository.findAll();
    }

    public SituationClientProfes findById(long id) throws MissingEntity {
        Optional<SituationClientProfes> situation = repository.findById(id);
        if (!situation.isPresent()) {
            throw new MissingEntity("Client not found with id = : " + id);
        }
        return situation.get();
    }

    private static final Logger log = LoggerFactory.getLogger(SituationClientService.class);
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private ClientProfes getClientById(Long clientId) throws MissingEntity {
        return clientProfesRepository.findById(clientId)
                .orElseThrow(() -> new MissingEntity("Client not found with id: " + clientId));
    }

    public Set<SituationClientProfes> uploadSituations(MultipartFile file) throws IOException {
        Set<SituationClientProfes> situations = parseCsv(file);
        repository.saveAll(situations);
        return situations;
    }

    private Set<SituationClientProfes> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<SituationCsvRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(SituationCsvRepresentation.class);

            CsvToBean<SituationCsvRepresentation> csvToBean = new CsvToBeanBuilder<SituationCsvRepresentation>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<SituationCsvRepresentation> csvLines = csvToBean.parse();

            return csvLines.stream()
                    .map(csvLine -> {
                        try {
                            return SituationClientProfes.builder()
                                    //.codeRelation(csvLine.getCodeRelation())
                                    .codeRelation(csvLine.getCodeRelation())
                                    //.dateNaissance(simpleDateFormat.parse(csvLine.getDateNaissance()))
                                    .dateDeSituation(simpleDateFormat.parse(csvLine.getDateDeSituation()))
                                    .numeroComptePrincipal(csvLine.getNumeroComptePrincipal())
                                    .consolidationInterne(csvLine.getConsolidationInterne())
                                    .mntEnConsolidation(csvLine.getMntEnConsolidation())
                                    .encoursCT(csvLine.getEncoursCT())
                                    .encoursMT(csvLine.getEncoursMT())
                                    .encoursCreditTresorerie(csvLine.getEncoursCreditTresorerie())
                                    .ratioEngagementCDR(csvLine.getVariationEngagementCDR())
                                    .consolidationAutresBanques(csvLine.getConsolidationAutresBanques())
                                    .besoinAccompagnement(csvLine.getBesoinAccompagnement())
                                    .besoinFinancement(csvLine.getBesoinFinancement())
                                    .trancheEffectif(csvLine.getTrancheEffectif())
                                    .nombreClients(csvLine.getNombreClients())
                                    .etatDuResultat(csvLine.getEtatDuResultat())
                                    .tailleBesoinFutur(csvLine.getTailleBesoinFutur())
                                    .classeBanqueCentrale(csvLine.getClasseBanqueCentrale())
                                    .anneeClassificationCentrale(csvLine.getAnneeClassificationCentrale())
                                    .ratingActuelleLegacy(csvLine.getRatingActuelleLegacy())
                                    .classeRisqueLegacy(csvLine.getClasseRisqueLegacy())
                                    .scoreClientLegacy(csvLine.getScoreClientLegacy())
                                    .dateRatingLegacy(simpleDateFormat.parse(csvLine.getDateRatingLegacy()))
                                    .impaye(csvLine.getImpaye())
                                    .montantImpayes(csvLine.getMontantImpayes())
                                    .ratioImpayesEngagements(csvLine.getRatioImpayesEngagements())
                                    .ancienneteImpayes(csvLine.getAncienneteImpayes())
                                    .mouvementsTotauxAnneeN(csvLine.getMouvementsTotauxAnneeN())
                                    .mouvementCreditieurAnneeN1(csvLine.getMouvementsTotauxAnneeN1())
                                    .mouvementCreditieurAnneeN(csvLine.getMouvementCreditieurAnneeN())
                                    .mouvementCreditieurAnneeN1(csvLine.getMouvementCreditieurAnneeN1())
                                    .mouvementDebiteurAnneeN(csvLine.getMouvementDebiteurAnneeN())
                                    .mouvementDebiteurAnneeN1(csvLine.getMouvementDebiteurAnneeN1())
                                    .ratioCreditSoldeMoyen(csvLine.getRatioCreditSoldeMoyen())
                                    .regulariteEcheances(csvLine.getRegulariteEcheances())
                                    .dernierSalaireYTD(csvLine.getDernierSalaireYTD())
                                    .soldeMoyenAnnuelAnneeN(csvLine.getSoldeMoyenAnnuelAnneeN())
                                    .soldeMoyenAnnuelAnneeN1(csvLine.getSoldeMoyenAnnuelAnneeN1())
                                    .totalCreancesGLE(csvLine.getTotalCreancesGLE())
                                    .variationAnnuelleMvtCreditAnneeN(csvLine.getVariationAnnuelleMvtCreditAnneeN())
                                    .variationAnnuelleMvtCreditAnneeN1(csvLine.getVariationAnnuelleMvtCreditAnneeN1())
                                    .variationMvtCredit(csvLine.getVariationMvtCredit())
                                    .rationSoldeMoyenFC(csvLine.getRationSoldeMoyenFC())
                                    .iarCentralDesRisquesCDR(csvLine.getIarCentralDesRisquesCDR())
                                    .variationEngagementCDR(csvLine.getVariationEngagementCDR())
                                    .mntCreditTresorerieCDR(csvLine.getMntCreditTresorerieCDR())
                                    .variationCreditTresoCDR(csvLine.getVariationCreditTresoCDR())
                                    .incident(csvLine.getIncident())
                                    .modeleApplicable(csvLine.getModeleApplicable())
                                    .autresInformation(csvLine.getAutresInformation())
                                    .commentaire(csvLine.getCommentaire())
                                    .variableLibre1(csvLine.getVariableLibre1())
                                    .variableLibre2(csvLine.getVariableLibre2())
                                    .variableLibre3(csvLine.getVariableLibre3())
                                    .variableLibre4(csvLine.getVariableLibre4())
                                    .variableLibre5(csvLine.getVariableLibre5())
                                    .variableLibre6(csvLine.getVariableLibre6())
                                    .variableLibre7(csvLine.getVariableLibre7())
                                    .build();
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }).collect(Collectors.toSet());
        }
    }

    @Autowired
   // SituationRepository repository;
    public List<SituationDto> getSituations() {
        return repository.findAll().stream()
                .map(SituationDto::of)
                .collect(Collectors.toList());
    }


    public SituationClientProfes getSituationById(long id) throws MissingEntity {
        Optional<SituationClientProfes> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new MissingEntity("situation not found with id: " + id);
        }
        return optional.get();
    }
    public Optional<SituationClientProfes> findSituationById(Long id) {
        return repository.findById(id);
    }
    public List<SituationClientProfes> searchByClientId(long clientId) throws MissingEntity{
        return repository.findByClientId(clientId);
    }
    public List<SituationClientProfes> searchByCodeRelation(long code_relation) throws MissingEntity{
        return repository.findByCodeRelation(code_relation);
    }
}

