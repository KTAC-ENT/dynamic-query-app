package org.dynamique.dynamicapp.resource.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class FilterDto {
    @NotEmpty
    private String query;
    @NotEmpty
    private List<String> fields;
    private List<String> wheres;
    private List<String> orderBys;

}
