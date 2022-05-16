package com.sg.dto;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@MongoEntity(database = "VIN", collection = "vinDetail")
@NoArgsConstructor
@AllArgsConstructor
public class VinDetails extends PanacheMongoEntity {
    private String vinPattern;
    private Integer basicWarrantyMiles;
    private String bodyType;
    private String cmsMake;
    private String engineAspiration;
    private String engineBlock;
    private String engineName;
    private String fuelType;
    private String make;
    private String model;
    private String cmsModel;
    private List<Trim> trim;
    private Integer modelId;
    private Integer modelYear;
    private Integer warrantyMiles;
    private Integer basicWarrantyTerm;
    private Integer warrantyMonths;
    private String warrantyName;
    private String engineType;

}
