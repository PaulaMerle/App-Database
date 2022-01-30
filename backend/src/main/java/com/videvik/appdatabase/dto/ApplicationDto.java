package com.videvik.appdatabase.dto;

import java.sql.Timestamp;
import java.util.List;


public record ApplicationDto(
    int appCode,
    String name,
    String appGroup,
    String appType,
    String description,
    int appCost,
    Timestamp modifiedTime,
    List<ServiceDto> services){
}
