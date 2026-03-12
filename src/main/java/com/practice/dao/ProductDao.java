package com.practice.dao;

import jakarta.persistence.EntityManager;

public class ProductDao {

    private final EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;

    }
}
