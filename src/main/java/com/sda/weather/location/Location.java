package com.sda.weather.location;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


@Data
@Entity
@Table(name="tabela")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cityName;
    private double latitude;
    private double longitude;
    private String countryName;
    private String region;

}
