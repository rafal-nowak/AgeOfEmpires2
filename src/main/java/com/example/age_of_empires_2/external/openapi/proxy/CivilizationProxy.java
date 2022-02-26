package com.example.age_of_empires_2.external.openapi.proxy;

import com.example.age_of_empires_2.external.api.response.Civilization;
import com.example.age_of_empires_2.external.api.response.CivilizationsApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="civilizations", url="https://age-of-empires-2-api.herokuapp.com/")
public interface CivilizationProxy {

    @GetMapping("api/v1/civilizations")
    CivilizationsApiResponse getCivilizations();

}
