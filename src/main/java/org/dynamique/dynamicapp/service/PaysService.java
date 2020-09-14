package org.dynamique.dynamicapp.service;

import org.dynamique.dynamicapp.resource.request.FilterDto;
import org.dynamique.dynamicapp.resource.response.AbstractResponse;
import org.dynamique.dynamicapp.resource.response.PaysResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.dynamique.dynamicapp.resource.response.FamillesResponse.FamillesResponseBuilder.aFamillesResponse;
import static org.dynamique.dynamicapp.resource.response.PaysResponse.PaysResponseBuilder.*;

@Service
public class PaysService implements Function<FilterDto, List<AbstractResponse>> {

    private List<AbstractResponse> pays(FilterDto filterDto) {
        return Collections.singletonList(aPaysResponse()
                .withAbrev("CMR")
                .withIndicateur("+237")
                .withNom("Cameroun")
                .build());
    }

    @Override
    public List<AbstractResponse> apply(FilterDto filterDto) {
        return pays(filterDto);
    }
}
