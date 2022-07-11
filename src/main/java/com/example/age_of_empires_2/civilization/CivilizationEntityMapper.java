package com.example.age_of_empires_2.civilization;

import com.example.age_of_empires_2.external.api.response.Civilization;
import org.mapstruct.Mapper;

@Mapper
public interface CivilizationEntityMapper {

    CivilizationEntity toEntity(Civilization response);

    Civilization toResponse(CivilizationEntity entity);

}
