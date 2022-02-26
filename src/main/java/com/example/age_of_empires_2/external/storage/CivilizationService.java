package com.example.age_of_empires_2.external.storage;

import com.example.age_of_empires_2.external.api.response.Civilization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CivilizationService {

    CivilizationRepository civilizationRepository;
    CivilizationEntityMapper mapper;

    public List<CivilizationEntity> findAll() {
        return civilizationRepository.findAll();
    }

    public void saveCivilizations(List<Civilization> civilizations) {
        List<CivilizationEntity> civilizationEntities = new ArrayList<>();
        for (Civilization civilization: civilizations) {
            civilizationEntities.add(mapper.toEntity(civilization));

        }
        civilizationRepository.saveAll(civilizationEntities);
    }
}
