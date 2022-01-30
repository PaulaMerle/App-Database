package com.videvik.appdatabase.service;

import com.videvik.appdatabase.dto.ServiceDto;
import com.videvik.appdatabase.entity.AppServiceEntity;
import com.videvik.appdatabase.entity.ApplicationEntity;
import com.videvik.appdatabase.repository.AppServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AppServiceService {
    private AppServiceRepository appServiceRepository;
    private GenericConversionService conversionService;

    public List<AppServiceEntity> findAll() {
        return appServiceRepository.findAll();
    }

    public AppServiceEntity findById(int theId) {
        return null;
    }

    public List<ApplicationEntity> findRelatedApplications(int theId) {
        return null;
    }

    public ServiceDto save(ServiceDto serviceDto) {
        var theService = conversionService.convert(serviceDto, AppServiceEntity.class);
        var savedService = appServiceRepository.save(theService);
        return conversionService.convert(savedService, ServiceDto.class);
    }

    public void deleteById(int theId) {

    }
}
