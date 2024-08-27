package com.pfe.Bank.controller;
import com.pfe.Bank.dto.SituationDto;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.SituationClientProfes;
import com.pfe.Bank.repository.FinanceRepository;
import com.pfe.Bank.repository.SituationRepository;
import com.pfe.Bank.service.SituationClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "",allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SituationController {
    @Autowired
    private SituationClientService situationClientService;
    @Autowired
    private SituationRepository repository;

    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping("/allsit")
    List<SituationDto> getAll(){
        List<SituationClientProfes> situationClientSnis =situationClientService.getAllSituation();
        return SituationDto.of(situationClientSnis);
    }

    @GetMapping(value = "/situation/{id}")
    public SituationDto getById(@PathVariable long id) throws MissingEntity {
        SituationClientProfes situationClientProfes = situationClientService.findById(id);
        return SituationDto.of(situationClientProfes);
    }
    @PostMapping(value = "/uploadSituation", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadSituations(
            @RequestPart("file") MultipartFile file) throws IOException {

        Set<SituationClientProfes> situations = situationClientService.uploadSituations(file);

        situations.forEach(situationClientProfes -> repository.save(situationClientProfes));

        return ResponseEntity.ok(situations.size());
    }

    @GetMapping("/ConsulterSituation")
    public List<SituationDto> getAllClients(){

        return situationClientService.getSituations();
    }

}
// Endpoint pour récupérer tous les clients