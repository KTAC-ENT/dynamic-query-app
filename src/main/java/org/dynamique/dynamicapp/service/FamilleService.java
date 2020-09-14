package org.dynamique.dynamicapp.service;

import org.dynamique.dynamicapp.resource.request.FilterDto;
import org.dynamique.dynamicapp.resource.response.AbstractResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static org.dynamique.dynamicapp.resource.response.FamillesResponse.FamillesResponseBuilder.aFamillesResponse;

@Service
public class FamilleService implements Function<FilterDto, List<? extends AbstractResponse>> {
    private final JdbcTemplate jdbcTemplate;

    public FamilleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<? extends AbstractResponse> familles(FilterDto filterDto) {

        StringBuilder sql = new StringBuilder("select * from f_familles ");
        if(Objects.nonNull(filterDto.getWheres())) {
            boolean isFirst=true;
            for (String where:filterDto.getWheres()) {
                if(isFirst) {
                    sql.append(String.format(" WHERE %s",where));
                    isFirst=false;
                } else {
                    sql.append(String.format(" AND %s",where));
                }
            }
        }

        if(Objects.nonNull(filterDto.getOrderBys())) {
            boolean isFirstOrderBy=true;
            for (String where:filterDto.getOrderBys()) {
                if(isFirstOrderBy) {
                    sql.append(String.format(" ORDER BY %s",where));
                    isFirstOrderBy=false;
                } else {
                    sql.append(String.format(", %s",where));
                }
            }
        }

        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> aFamillesResponse()
                    .withNom(rs.getString(1))
                    .withPrenom(rs.getString(2))
                    .build()
        );
    }

    @Override
    public List<? extends AbstractResponse> apply(FilterDto filterDto) {
        return familles(filterDto);
    }
}
