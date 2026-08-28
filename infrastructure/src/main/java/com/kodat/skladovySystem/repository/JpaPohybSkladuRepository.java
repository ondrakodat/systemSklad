package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.PohybSkladu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPohybSkladuRepository extends JpaRepository<PohybSkladu, Long> {
}
