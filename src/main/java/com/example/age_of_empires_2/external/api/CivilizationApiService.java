package com.example.age_of_empires_2.external.api;

import com.example.age_of_empires_2.external.openapi.response.Civilization;
import com.example.age_of_empires_2.external.openapi.response.CivilizationsApiResponse;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class CivilizationApiService implements CivilizationApiConfiguration {

    private CivilizationApiInterface service;

    public CivilizationApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(CivilizationApiInterface.class);
    }

    public List<Civilization> getAllCivilizations() throws IOException {
        Response<CivilizationsApiResponse> response = service.getCivilizations().execute();
        List<Civilization> civilizations = response.body().getCivilizations();
        return civilizations;
    }
}
