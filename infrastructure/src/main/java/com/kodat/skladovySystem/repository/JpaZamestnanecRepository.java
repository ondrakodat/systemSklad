package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Zamestnanec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaZamestnanecRepository extends JpaRepository<Zamestnanec, Long> {
}
