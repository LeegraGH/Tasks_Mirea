package com.example.other_tasks.utils;

import com.example.other_tasks.models.Card;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.Attribute;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CardSpecification implements Specification<Card> {
    private final String criteria;

    @Override
    public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (Attribute<? super Card, ?> attribute : root.getModel().getAttributes()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(criteriaBuilder.toString(root.get(attribute.getName()))), "%" + criteria.toLowerCase() + "%"));
        }
        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
    }
}
