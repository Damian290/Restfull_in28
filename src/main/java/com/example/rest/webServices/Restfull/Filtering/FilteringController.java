package com.example.rest.webServices.Restfull.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Acer on 2019-12-27.
 */

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retreiveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
//        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("field1", "field2");//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFIlter", filter);
//        mapping.setFilters(filters);

        return createFilter(someBean,"field1","field2");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retreiveListOfSomeBean(){
        List<SomeBean> listOfSomeBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value11", "value12", "value13"));


//        MappingJacksonValue mapping = new MappingJacksonValue(listOfSomeBeans);
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("field3", "field2");//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFIlter", filter);
//        mapping.setFilters(filters);

        return createFilter(listOfSomeBeans,"field2","field3");
    }

    public <T> MappingJacksonValue createFilter(T t, String field1, String field2 ){
        MappingJacksonValue mapping = new MappingJacksonValue(t);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(field1, field2);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFIlter", filter);
        mapping.setFilters(filters);
        return mapping;

    }
}
