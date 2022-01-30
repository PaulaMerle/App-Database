package com.videvik.appdatabase.converter;

import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface Converter extends GenericConverter {

    default <T, O> List<O> convert(
            Collection<T> sources, Class<O> oClass, GenericConversionService service) {
        return sources == null ? Collections.emptyList() : sources.stream()
                .map(source -> service.convert(source, oClass)).toList();
    }
}
