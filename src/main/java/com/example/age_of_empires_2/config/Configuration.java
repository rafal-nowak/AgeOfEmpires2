package com.example.age_of_empires_2.config;

import com.example.age_of_empires_2.civilization.CivilizationEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@EnableFeignClients(basePackages = "com.example.age_of_empires_2.external.api.proxy")
public class Configuration {

    @Bean
    public CivilizationEntityMapper taskEntityMapper() {
        return Mappers.getMapper(CivilizationEntityMapper.class);
    }

}
