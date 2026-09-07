package com.kodat.skladovySystem.repository;

public class InventarRepository {
    private final JpaInventarRepository _JpaInventarRepository;

    public InventarRepository(JpaInventarRepository jpaInventarRepository) {
        _JpaInventarRepository = jpaInventarRepository;
    }


}
