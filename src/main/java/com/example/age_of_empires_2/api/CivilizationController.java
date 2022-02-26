package com.example.age_of_empires_2.api;

import com.example.age_of_empires_2.external.api.CivilizationApiService;
import com.example.age_of_empires_2.external.api.response.Civilization;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class CivilizationController {

    CivilizationApiService civilizationApiService;

    @GetMapping("/civilizations")
    List<Civilization> getAllCivilizations() throws IOException {
        return civilizationApiService.getAllCivilizations();
    }

}
