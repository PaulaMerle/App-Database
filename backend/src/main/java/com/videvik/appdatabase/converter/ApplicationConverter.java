package com.videvik.appdatabase.converter;


import com.videvik.appdatabase.dto.ApplicationDto;
import com.videvik.appdatabase.dto.ServiceDto;
import com.videvik.appdatabase.entity.AppServiceEntity;
import com.videvik.appdatabase.entity.ApplicationEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ApplicationConverter implements Converter {
    private GenericConversionService conversionService;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(ApplicationEntity.class, ApplicationDto.class));
        convertiblePairs.add(new ConvertiblePair(ApplicationDto.class, ApplicationEntity.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(sourceType.getType() == ApplicationDto.class) {
            var dto = (ApplicationDto) source;
            var entity = ApplicationEntity.builder()
                    .id(dto.appCode())
                    .name(dto.name())
                    .appGroup(dto.appGroup())
                    .appType(dto.appType())
                    .description(dto.description())
                    .appCost(dto.appCost())
                    .lastModified(dto.modifiedTime())
                    .services(convert(dto.services(), AppServiceEntity.class, conversionService))
                    .build();
            entity.assignToServices();
            return entity;
        }

        var entity = (ApplicationEntity) Hibernate.unproxy(source);
        return new ApplicationDto(
                entity.getId(),
                entity.getName(),
                entity.getAppGroup(),
                entity.getAppType(),
                entity.getDescription(),
                entity.getAppCost(),
                entity.getLastModified(),
                convert(entity.getServices(), ServiceDto.class, conversionService));
    }
}
