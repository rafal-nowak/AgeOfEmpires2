package com.example.age_of_empires_2.api;

import com.example.age_of_empires_2.external.storage.CivilizationEntity;
import com.example.age_of_empires_2.external.storage.CivilizationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CivilizationControllerTest {

    @Mock
    private CivilizationService civilizationService;

    @InjectMocks
    private CivilizationController civilizationController;

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
    void search_for_civilizations_method_should_return_all_civilizations_when_arguments_are_empty() throws IOException {
        Mockito.when(civilizationService.findAll()).thenReturn(fakeCivilizationsList);

        //when
        List<CivilizationEntity> foundedCivilizations = civilizationController.searchForCivilizations("", "");

        //then
        Assertions.assertNotNull(foundedCivilizations);
        Assertions.assertEquals(2, foundedCivilizations.size());
        Assertions.assertEquals(fakeCivilization1, foundedCivilizations.get(0));
        Assertions.assertEquals(fakeCivilization2, foundedCivilizations.get(1));
    }

    @Test
    void search_for_civilizations_method_should_return_correct_civilizations_when_arguments_are_specified() throws IOException {
        Mockito.when(civilizationService.findAll()).thenReturn(fakeCivilizationsList);

        //when
        List<CivilizationEntity> foundedCivilizations = civilizationController.searchForCivilizations("Foot", "");

        //then
        Assertions.assertNotNull(foundedCivilizations);
        Assertions.assertEquals(1, foundedCivilizations.size());
        Assertions.assertEquals(fakeCivilization2, foundedCivilizations.get(0));
    }
}