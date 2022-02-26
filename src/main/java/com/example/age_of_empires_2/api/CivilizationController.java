package com.example.age_of_empires_2.api;

import com.example.age_of_empires_2.external.api.CivilizationApiService;
import com.example.age_of_empires_2.external.api.response.Civilization;
import com.example.age_of_empires_2.external.storage.CivilizationEntity;
import com.example.age_of_empires_2.external.storage.CivilizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class CivilizationController {

    CivilizationApiService civilizationApiService;
    CivilizationService civilizationService;

    @GetMapping("/civilizations")
    List<Civilization> getAllCivilizations() throws IOException {
        return civilizationApiService.getAllCivilizations();
    }

    @GetMapping("/civilizations-from-db")
    List<CivilizationEntity> getAllCivilizationsFromDB() {
        return civilizationService.findAll();
    }

    @GetMapping("/grab-civilizations")
    List<Civilization> grabAllCivilizationToDB() throws IOException {
        List<Civilization> civilizations = civilizationApiService.getAllCivilizations();

        civilizationService.saveCivilizations(civilizations);

        return civilizations;
    }

}
