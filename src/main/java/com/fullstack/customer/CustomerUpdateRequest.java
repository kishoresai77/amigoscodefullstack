package com.fullstack.customer;

import jakarta.persistence.criteria.CriteriaBuilder;

public record CustomerUpdateRequest(
    String name,
    String email,
    Integer age
){}
