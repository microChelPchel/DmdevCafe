package com.csv;

import com.model.Order;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public interface CsvRow {

    String SEPARATOR = ",";

    List<Object> values();

    default String toCsvRow() {
        return values().stream()
                .map(String::valueOf)
                .collect(joining(SEPARATOR));
    }

}
