package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Sklad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSkladRepository extends JpaRepository<Sklad, Long> {
    List<Sklad> findByNazevContainingNazevIgnoreCase(String nazev);
}
