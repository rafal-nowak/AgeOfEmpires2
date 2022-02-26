package com.example.age_of_empires_2.external.api.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class CivilizationsApiResponse {
    private List<Civilization> civilizations;
}
