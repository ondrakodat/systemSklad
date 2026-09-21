package com.kodat.skladovysystem.repository;

import com.kodat.skladovysystem.entities.Inventar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInventarRepository extends JpaRepository<Inventar, Long> {
}
