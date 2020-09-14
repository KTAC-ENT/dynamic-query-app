package org.dynamique.dynamicapp.resource;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

public enum QueryType {
    FAMILLES("familles", "familleService"), PAYS("pays", "paysService");
    private final String name;
    private final String bean;

    QueryType(String name, String bean) {
        this.name = name;
        this.bean = bean;
    }

    public static Optional<String> getBean(String name) {
        return Stream.of(QueryType.values())
                .filter(type -> type.name.equals(name))
                .map(type -> type.bean)
                .findFirst();
    }
}
