package com.pfe.Bank.controller;
import com.pfe.Bank.dto.ScoreDto;
import com.pfe.Bank.dto.VariableDto;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.*;
import com.pfe.Bank.repository.*;
import com.pfe.Bank.service.CalculScoreService;
import com.pfe.Bank.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.pfe.Bank.model.Type.ENUMERATION;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VariableController {

    @Autowired
    VariableService variableService;
    @Autowired
    ModeleRepository modeleRepository;
    @Autowired
    VariableRepository variableRepository;
    @Autowired
    CalculScoreService calculScoreService;
    @Autowired
    ScoreVariableRepository scoreVariableRepository;
    @Autowired
    ClientProfesRepository clientProfesRepository;
    @Autowired
    SituationRepository situationRepository;

    @PostMapping("/addVariable/{modelId}")
    public ResponseEntity<Variable> addVariable(@RequestBody VariableDto variableRequest, @PathVariable long modelId) {
        try {
            Modele modele = modeleRepository.findById(modelId)
                    .orElseThrow(() -> new EntityNotFoundException("No active Modele found with ID: " + modelId));

            Variable variable = new Variable();
            variable.setCode(variableRequest.getCode());
            variable.setDescription(variableRequest.getDescription());
            variable.setCoefficient(variableRequest.getCoefficient());
            variable.setType(variableRequest.getType());
            variable.setResponseMeaning(variableRequest.getResponseMeaning());
            variable.setModele(modele);

            Variable createdVariable = variableService.createVariable(variable, modelId);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdVariable);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /* @PostMapping("/addVariable")
  public ResponseEntity<Variable> createVariable(@RequestBody Variable variable) {
      Variable createdVariable = variableService.createVariable(variable);
      return new ResponseEntity<>(createdVariable, HttpStatus.CREATED);
  }*/
    @PostMapping("/{variableId}/scores")
    public ResponseEntity<Score> addScoreToVariable(
            @PathVariable long variableId,
            @RequestBody Score score) {
        try {
            variableService.addScoreToVariable(variableId, score);
            return new ResponseEntity<>(score, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    // hedhi
    @GetMapping("/getAllVariables/{clientId}")
    public ResponseEntity<List<VariableDto>> getAllVariablesWithScores(@PathVariable long clientId) {
        List<Variable> variables = variableService.getAllVariable();
        /*Modele modele = modeleRepository.findByUsedTrue()
                .orElseThrow(() -> new EntityNotFoundException("No active Modele found"));*/
        System.out.println(variables.toString());

        List<VariableDto> variableDtos = variables.stream().map(variable -> {
            VariableDto variableDto = new VariableDto();
            variableDto.setId(variable.getId());
            variableDto.setCode(variable.getCode());
            variableDto.setCoefficient(variable.getCoefficient());
            variableDto.setType(variable.getType());
            variableDto.setDescription(variable.getDescription());
            variableDto.setResponse(variableDto.getResponse());
            //variableDto.setModelId(variable.getModele().getId());

            if(ENUMERATION.equals(variable.getType())) {
                List<ScoreDto> scoreDtos = variable.getScores().stream()
                        .map(score -> {
                            com.pfe.Bank.model.ENUMERATION enumeration = (ENUMERATION) score;
                            ScoreDto scoreDto = new ScoreDto();
                            scoreDto.setId(score.getId());
                            scoreDto.setScore(score.getScore());
                            scoreDto.setValeur(enumeration.getValeur());
                            return scoreDto;
                        }).collect(Collectors.toList());

                variableDto.setScores(scoreDtos);
            }
            System.out.println(variable.getScores().toString());

            ClientProfes clientProfes = clientProfesRepository.findById(clientId).get();
            SituationClientProfes situationClientProfes = situationRepository.findByCodeRelation(clientProfes.getCodeRelation()).get(0);

            if(Objects.nonNull(variable.getResponseMeaning())) {
                switch (variable.getResponseMeaning()) {
                    case PROFESSION:
                        variableDto.setResponse(clientProfes.getProfession());
                        break;

                    case DATENAISSANCE:
                        variableDto.setResponse(clientProfes.getDateNaissance().toString());
                        break;

                    case SECTEURACTIVITE:
                        variableDto.setResponse(clientProfes.getSecteurActivite());
                        break;

                    case CHIFFREAFFAIRE:
                        variableDto.setResponse(String.valueOf(clientProfes.getChiffreAffaire()));
                        break;

                    case DENOMINATIONSOCIALE:
                        variableDto.setResponse(clientProfes.getDenominationSociale());
                        break;
                    case MntEnConsolidation:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getMntEnConsolidation()));
                        break;
                    case  ANCIENNETEIMPAYES :
                        variableDto.setResponse(String.valueOf(situationClientProfes.getAncienneteImpayes()));
                        break;
                    case IMPAYE:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getImpaye()));
                        break;
                    case SOLDEMOYENANNUELANNEEN:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getSoldeMoyenAnnuelAnneeN()));
                        break;
                    case MONTANTIMPAYES:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getMontantImpayes()));
                        break;
                    case REGULARITEECHEANCES:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getRegulariteEcheances()));
                        break;

                    case RATIOENGAGEMENTCDR:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getRatioEngagementCDR()));
                        break;
                    case SOLDEMOYENANNUEANNEEN1:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getSoldeMoyenAnnuelAnneeN1()));
                        break;
                    case CLASSERISQUELEGACY:
                        variableDto.setResponse(String.valueOf(situationClientProfes.getClasseRisqueLegacy()));
                        break;

                    case IDENTIFIANTNATIONAL:
                        variableDto.setResponse(String.valueOf(clientProfes.getIdNat()));
                        break;
                    case DATEDENAISSANCE:
                        variableDto.setResponse(String.valueOf(clientProfes.getDateNaissance()));
                        break;
                }
            }


            return variableDto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(variableDtos);
    }

    @GetMapping("/getAllVariables")
    public ResponseEntity<List<VariableDto>> getAllVariablesWithScores() {
        List<Variable> variables = variableService.getAllVariable();
        /*Modele modele = modeleRepository.findByUsedTrue()
                .orElseThrow(() -> new EntityNotFoundException("No active Modele found"));*/
        System.out.println(variables.toString());

        List<VariableDto> variableDtos = variables.stream().map(variable -> {
            VariableDto variableDto = new VariableDto();
            variableDto.setId(variable.getId());
            variableDto.setCode(variable.getCode());
            variableDto.setCoefficient(variable.getCoefficient());
            variableDto.setType(variable.getType());
            variableDto.setDescription(variable.getDescription());
            //variableDto.setModelId(variable.getModele().getId());

            if(ENUMERATION.equals(variable.getType())) {
                List<ScoreDto> scoreDtos = variable.getScores().stream()
                        .map(score -> {
                            com.pfe.Bank.model.ENUMERATION enumeration = (ENUMERATION) score;
                            ScoreDto scoreDto = new ScoreDto();
                            scoreDto.setId(score.getId());
                            scoreDto.setScore(score.getScore());
                            scoreDto.setValeur(enumeration.getValeur());
                            return scoreDto;
                        }).collect(Collectors.toList());

                variableDto.setScores(scoreDtos);
            }
            System.out.println(variable.getScores().toString());

            return variableDto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(variableDtos);
    }

    @GetMapping("/getVariableScoreById/{id}")
    public ResponseEntity<VariableDto> getVariableWithScores(@PathVariable Long id) throws MissingEntity {
        Variable variable = variableService.findById(id);
        //List<ScoreDto> scoreDtos = variableService.getScoresByVariableId(id);

        VariableDto variableDto = new VariableDto();
        variableDto.setId(variable.getId());
        variableDto.setCode(variable.getCode());
        variableDto.setDescription(variable.getDescription());
        variableDto.setCoefficient(variable.getCoefficient());
        variableDto.setType(variable.getType());
        variableDto.setModelId(variable.getModele().getId());
        variableDto.setResponse(variableDto.getResponse());
        //variableDto.setScores(scoreDtos);

        return ResponseEntity.ok(variableDto);
    }

    @PutMapping("/updataVariable/{id}")
    public ResponseEntity<Variable> updateVariable(@PathVariable Long id, @RequestBody Variable updatedVariable) {
        Variable updateVariable = variableService.updateVariable(id, updatedVariable);
        return ResponseEntity.ok(updateVariable);
    }

    @DeleteMapping("/deleteVariable/{id}")
    public ResponseEntity<Void> deleteVariable(@PathVariable Long id) {
        try {
            variableService.deleteVariable(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ponderation/{id}")
    public double getPonderationForVariable(@PathVariable Long id) {
        return variableService.calculatePonderationForVariable(id);
    }
}
