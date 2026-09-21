package com.kodat.skladovysystem.repository;

import com.kodat.skladovysystem.entities.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaKategorieRepository extends JpaRepository<Kategorie, Long> {
}
