package com.example.age_of_empires_2.external.openapi.response;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Civilization {
    private Long id;
    private String name;
    private String expansion;
    private String army_type;
}
