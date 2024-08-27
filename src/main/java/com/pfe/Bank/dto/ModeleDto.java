package com.pfe.Bank.dto;

import com.pfe.Bank.form.ModeleForm;
import com.pfe.Bank.model.Modele;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeleDto extends ModeleForm {
    private long id;
    private List<VariableDto> variables;
    public static ModeleDto of(Modele modele) {
        ModeleDto dto = new ModeleDto();
        dto.setId(modele.getId());
        dto.setName(modele.getName());
        dto.setDescription(modele.getDescription());
        dto.setVariables(modele.getVariables().stream()
                .map(VariableDto::of)
                .collect(Collectors.toList()));
        return dto;
    }
    public ModeleDto(Modele modele) {
        super(modele);
        this.id = modele.getId();
    }

    public static List<ModeleDto> of(List<Modele> modeles) {
        return modeles.stream().map(ModeleDto::of).collect(Collectors.toList());
    }
}
