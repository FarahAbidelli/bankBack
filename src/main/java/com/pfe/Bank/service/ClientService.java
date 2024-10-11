package com.pfe.Bank.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.Client;
import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public Set<ClientProfes> uploadClients(MultipartFile file) throws IOException {
        Set<ClientProfes> clients = parseCsv(file);
        Set<ClientProfes> updatedClients = new HashSet<>();

        for (ClientProfes clientProfes : clients) {
            Optional<Client> existingClientOptional = clientRepository.findByCodeRelationAndIdNat(clientProfes.getCodeRelation(), clientProfes.getIdNat());
            if (existingClientOptional.isPresent()) {
                Client existingClient = existingClientOptional.get();

                if (existingClient instanceof ClientProfes) {
                    ClientProfes existingClientProfes = (ClientProfes) existingClient;
                    existingClientProfes.setChiffreAffaire(existingClientProfes.getChiffreAffaire());
                    existingClientProfes.setDateRNE(existingClientProfes.getDateRNE());
                    existingClientProfes.setGouvernorat(existingClientProfes.getGouvernorat());
                    existingClientProfes.setDenominationSociale(existingClientProfes.getDenominationSociale());
                    existingClientProfes.setDateDebutRelation(existingClientProfes.getDateDebutRelation());
                    existingClientProfes.setSegment(existingClientProfes.getSegment());
                    existingClientProfes.setDateNaissance(existingClientProfes.getDateNaissance());
                    existingClientProfes.setAgence(existingClientProfes.getAgence());
                    existingClientProfes.setSecteurActivite(existingClientProfes.getSecteurActivite());
                    clientRepository.save(existingClient);
                    updatedClients.add(existingClientProfes);
                    log.info("ClientProfes mis à jour : " + existingClientProfes);
                }
            } else {
                clientRepository.save(clientProfes);
                updatedClients.add(clientProfes);
                log.info("Nouveau ClientProfes inséré : " + clientProfes);
            }
        }
        return updatedClients;
    }


    /*public Set<Client> uploadClients(MultipartFile file) throws IOException {
        return parseCsv(file);
    }*/

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Set<ClientProfes> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<ClientCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ClientCsvRepresentation.class);
            CsvToBean<ClientCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<ClientCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> {
                                try {
                                    System.out.println(csvLine.getCodeRelation());
                                    ClientProfes clientProfes = ClientProfes.builder()
                                            .codeRelationFlexcube(csvLine.getCodeRelationFlexcube())
                                            .identifiantProspect(csvLine.getIdentifiantProspect())
                                            .profession(csvLine.getProfession())
                                            .adresse(csvLine.getAdresse())
                                            .agence(csvLine.getAgence())
                                            .ville(csvLine.getVille())
                                            .codeRelation(csvLine.getCodeRelation())
                                            .idNat(csvLine.getIdNat())
                                            .region(csvLine.getRegion())
                                            .dateNaissance(simpleDateFormat.parse(csvLine.getDateNaissance()))
                                            .dateDebutRelation(simpleDateFormat.parse(csvLine.getDateDebutRelation()))
                                            .autre(csvLine.getAutre())
                                            .dateRNE(simpleDateFormat.parse(csvLine.getDateRNE()))
                                            .secteurActivite(csvLine.getSecteurActivite())
                                            .perimetreActivite(csvLine.getPerimetreActivite())
                                            .chiffreAffaire(csvLine.getChiffreAffaire())
                                            .segment(csvLine.getSegment())
                                            .gouvernorat(csvLine.getGouvernorat())
                                            .denominationSociale(csvLine.getDenominationSociale())
                                            .build();
                                    log.info(clientProfes.toString());
                                    return clientProfes;
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                    ).collect(Collectors.toSet());
        }

    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public Client getClientById(long id) throws MissingEntity {
        Optional<Client> optional = clientRepository.findById(id);
        if (!optional.isPresent()) {
            throw new MissingEntity("client not found with id: " + id);
        }
        return optional.get();
    }
    @Transactional
    public Map<String, Boolean> deleteClient(long id) throws MissingEntity {
        Client client = getClientById(id);
        clientRepository.delete(client);
        Map<String,Boolean> map = new HashMap<>();
        map.put(" client deleted",Boolean.TRUE);
        return map;
    }


    }
