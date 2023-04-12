package com.example.other_tasks.utils;

import com.example.other_tasks.models.Bank;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Attribute;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BankSpecification implements Specification<Bank> {

    private final String criteria;

    @Override
    public Predicate toPredicate(Root<Bank> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (Attribute<? super Bank, ?> attribute : root.getModel().getAttributes()) {
            if (attribute.getJavaType().equals(String.class)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(attribute.getName())), "%" + criteria.toLowerCase() + "%"));
            }
        }
        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
    }

}
