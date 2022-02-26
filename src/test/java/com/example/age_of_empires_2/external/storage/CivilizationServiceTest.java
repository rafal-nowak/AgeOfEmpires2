package com.example.age_of_empires_2.external.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CivilizationServiceTest {

    @Mock
    private CivilizationRepository civilizationRepository;

    @InjectMocks
    private CivilizationService civilizationService;

    private final CivilizationEntity fakeCivilization1 = new CivilizationEntity(
            1L,
            "Aztecs",
            "The Conquerors",
            "Infantry and Monk"
    );

    private final CivilizationEntity fakeCivilization2 = new CivilizationEntity(
            2L,
            "Britons",
            "Age of Kings",
            "Foot Archer"
    );

    private final List<CivilizationEntity> fakeCivilizationsList = Arrays.asList(fakeCivilization1, fakeCivilization2);

    @Test
    void find_all_method_return_all_civilizations() {
        Mockito.when(civilizationRepository.findAll()).thenReturn(fakeCivilizationsList);

        //when
        List<CivilizationEntity> foundedCivilizations = civilizationService.findAll();

        //then
        Assertions.assertNotNull(foundedCivilizations);
        Assertions.assertEquals(2, foundedCivilizations.size());
        Assertions.assertEquals(fakeCivilization1, foundedCivilizations.get(0));
        Assertions.assertEquals(fakeCivilization2, foundedCivilizations.get(1));
    }

}