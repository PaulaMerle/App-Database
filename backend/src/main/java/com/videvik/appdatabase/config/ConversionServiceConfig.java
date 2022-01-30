package com.videvik.appdatabase.config;

import com.videvik.appdatabase.converter.ApplicationConverter;
import com.videvik.appdatabase.converter.ServiceConverter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

@AllArgsConstructor
@Configuration
public class ConversionServiceConfig {

    @Bean
    public GenericConversionService conversionService() {
        GenericConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new ApplicationConverter(conversionService));
        return conversionService;
    }
}
