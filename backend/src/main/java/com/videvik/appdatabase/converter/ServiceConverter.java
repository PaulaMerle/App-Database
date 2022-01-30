package com.videvik.appdatabase.converter;

import com.videvik.appdatabase.dto.ServiceDto;
import com.videvik.appdatabase.entity.AppServiceEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.core.convert.TypeDescriptor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ServiceConverter implements Converter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(AppServiceEntity.class, ServiceDto.class));
        convertiblePairs.add(new ConvertiblePair(ServiceDto.class, AppServiceEntity.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(sourceType.getType() == ServiceDto.class) {
            var dto = (ServiceDto) source;
            var entity = AppServiceEntity.builder()
                    .serviceCode(dto.serviceCode())
                    .name(dto.name())
                    .application(dto.application())
                    .type(dto.type())
                    .subType(dto.subType())
                    .description(dto.description())
                    .lastModified(dto.lastModified())
                    .build();
            return entity;
        }
        var entity = (AppServiceEntity) Hibernate.unproxy(source);
        return new ServiceDto(
                entity.getServiceCode(),
                entity.getName(),
                entity.getType(),
                entity.getSubType(),
                entity.getDescription(),
                entity.getLastModified(),
                entity.getApplication());
    }
}
