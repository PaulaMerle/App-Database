package com.videvik.appdatabase.service;

import com.videvik.appdatabase.dto.ApplicationDto;
import com.videvik.appdatabase.entity.ApplicationEntity;
import com.videvik.appdatabase.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final GenericConversionService conversionService;


    public List<ApplicationEntity> findAll() {
        return applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public ApplicationEntity findById(int theId) {
        return null;
    }

    public ApplicationDto save(ApplicationDto applicationDto) {
        var theApplication = conversionService.convert(applicationDto, ApplicationEntity.class);
        var savedApplication = applicationRepository.save(theApplication);
        return conversionService.convert(savedApplication, ApplicationDto.class);
    }

   public void deleteById(int theId) {}

   public ApplicationEntity getById(int id){ return null; }

}
