package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Rezervace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryRezervace extends JpaRepository<Rezervace, Long> {
}
