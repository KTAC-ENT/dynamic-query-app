package org.dynamique.dynamicapp.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.dynamique.dynamicapp.resource.request.FilterDto;
import org.dynamique.dynamicapp.resource.response.AbstractResponse;
import org.dynamique.dynamicapp.resource.response.FamillesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.dynamique.dynamicapp.resource.response.FamillesResponse.FamillesResponseBuilder.aFamillesResponse;

@RestController
@RequestMapping("/api/v1/find-entity")
@Slf4j
public class DynamicResource {

    private final ObjectMapper objectMapper;
    private final ApplicationContext applicationContext;

    public DynamicResource(ObjectMapper objectMapper, ApplicationContext applicationContext) {
        this.objectMapper = objectMapper;
        this.applicationContext = applicationContext;
    }

    @GetMapping
    public List<AbstractResponse> findEntity(@Valid FilterDto filterDto) {
        logParameters(filterDto);
        Function<FilterDto, List<AbstractResponse>> function= (Function<FilterDto, List<AbstractResponse>>) applicationContext
                .getBean(QueryType.getBean(filterDto.getQuery())
                .orElseThrow(()->new RuntimeException("Not support operation")));
        return function.apply(filterDto);
    }

    private void logParameters(FilterDto filterDto) {
        try {
            log.info(objectMapper.writeValueAsString(filterDto));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
