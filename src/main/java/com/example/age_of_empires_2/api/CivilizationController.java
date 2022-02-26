package com.example.age_of_empires_2.api;

import com.example.age_of_empires_2.external.api.CivilizationApiService;
import com.example.age_of_empires_2.external.api.response.Civilization;
import com.example.age_of_empires_2.external.storage.CivilizationEntity;
import com.example.age_of_empires_2.external.storage.CivilizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CivilizationController {

    CivilizationApiService civilizationApiService;
    CivilizationService civilizationService;

    @GetMapping("/search")
    public List<CivilizationEntity> searchForCivilizations(
            @RequestParam(name = "army_type", required = false, defaultValue = "") String army_type,
            @RequestParam(name = "expansion", required = false, defaultValue = "") String expansion
    ) throws IOException {
        List<CivilizationEntity> civilizations = civilizationService.findAll();

        if(civilizations.size() == 0) {
            List<Civilization> grabedCivilizations = civilizationApiService.getAllCivilizations();
            civilizationService.saveCivilizations(grabedCivilizations);
            civilizations = civilizationService.findAll();
        }

        List<CivilizationEntity> foundedCivilizations = civilizations
                .stream()
                .filter(civilization -> civilization.getArmy_type().contains(army_type) && civilization.getExpansion().contains(expansion))
                .collect(Collectors.toList());

        return foundedCivilizations;
    }

}
