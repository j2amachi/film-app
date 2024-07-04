package com.amachi.app.film.common.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Configuration
public class UiOrderToEntityOrderPropertyMapper {
    private final Map<String, String> dtoToEntityPropertyMap;
    private final Map<String, String> entityToDtoPropertyMap;

    public UiOrderToEntityOrderPropertyMapper(Map<String, String> dtoToEntityPropertyMap) {
        this.dtoToEntityPropertyMap = dtoToEntityPropertyMap;
        this.entityToDtoPropertyMap = new HashMap<>(dtoToEntityPropertyMap.size());
        dtoToEntityPropertyMap.entrySet().stream().forEach(e -> this.entityToDtoPropertyMap.put(e.getValue(), e.getKey()));
    }

    protected static String getIdFieldPath(String idFieldName, String fieldName) {
        return String.format("%s.%s", idFieldName, fieldName);
    }

    public Pageable convertToEntityPage(Pageable pageable) {
        return convertPage(pageable, this::mapToEntityProperty);
    }

    public Pageable convertToDtoPage(Pageable pageable) {
        return convertPage(pageable, this::mapToDtoProperty);
    }

    private Pageable convertPage(Pageable pageable, UnaryOperator<Order> propertyMapper) {
        Sort jpaSort = pageable.getSort();
        List<Order> entityOrder = jpaSort.get().map(propertyMapper).collect(Collectors.toList());
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(entityOrder));
    }

    private Order mapToEntityProperty(Order order) {
        return mapProperty(order, dtoToEntityPropertyMap);
    }

    private Order mapToDtoProperty(Order order) {
        return mapProperty(order, entityToDtoPropertyMap);
    }

    private Order mapProperty(Order order, Map<String, String> mapForMapping) {
        String orderProperty = order.getProperty();
        Order res = order;
        if (mapForMapping.containsKey(orderProperty)) {
            res = new Order(order.getDirection(), mapForMapping.get(orderProperty), order.getNullHandling());
        }
        return res;
    }
}
