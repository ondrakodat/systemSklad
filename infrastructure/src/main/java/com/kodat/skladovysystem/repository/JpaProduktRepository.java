package com.kodat.skladovysystem.repository;

import com.kodat.skladovysystem.entities.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProduktRepository extends JpaRepository<Produkt, Long> {
    List<Produkt> findByNazevContainingIgnoreCase(String nazev);
}
