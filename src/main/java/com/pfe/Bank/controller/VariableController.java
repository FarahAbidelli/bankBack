package com.pfe.Bank.controller;
import com.pfe.Bank.dto.ScoreDto;
import com.pfe.Bank.dto.VariableDto;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.ENUMERATION;
import com.pfe.Bank.model.Modele;
import com.pfe.Bank.model.Score;
import com.pfe.Bank.model.Variable;
import com.pfe.Bank.repository.ModeleRepository;
import com.pfe.Bank.repository.ScoreVariableRepository;
import com.pfe.Bank.repository.VariableRepository;
import com.pfe.Bank.service.CalculScoreService;
import com.pfe.Bank.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
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
