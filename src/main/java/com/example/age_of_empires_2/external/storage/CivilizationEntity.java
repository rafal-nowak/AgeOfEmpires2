package com.example.age_of_empires_2.external.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "civilizations")
public class CivilizationEntity {
    @Id
    Long id;
    private String name;
    private String expansion;
    private String army_type;
}
