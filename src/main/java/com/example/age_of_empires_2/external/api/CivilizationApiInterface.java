package com.example.age_of_empires_2.external.api;

import com.example.age_of_empires_2.external.api.response.CivilizationsApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.age_of_empires_2.external.api.CivilizationApiConfiguration.API_SOURCE_URL;

public interface CivilizationApiInterface {

    @GET(API_SOURCE_URL)
    Call<CivilizationsApiResponse> getCivilizations();

}
