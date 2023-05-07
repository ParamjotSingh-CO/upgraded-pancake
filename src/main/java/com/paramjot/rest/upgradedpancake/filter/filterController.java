package com.paramjot.rest.upgradedpancake.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filterController {

    @GetMapping("dynamicFilter")
    public MappingJacksonValue filterProtagonistForThisURL(){
        Series breakingBad = new Series("Breaking Bad", "Walter White", "Hank", "Crime/Drama");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(breakingBad);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("Protagonist");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SeriesPropertyFilter", simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
