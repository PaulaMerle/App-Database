package com.videvik.appdatabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.videvik.appdatabase.entity.ApplicationEntity;

import java.sql.Timestamp;

public record ServiceDto(
        int serviceCode,
        String name,
        String type,
        String subType,
        String description,
        Timestamp lastModified,
        @JsonProperty("appCode")
        ApplicationEntity application) {
}
