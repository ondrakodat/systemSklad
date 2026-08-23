package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProduktRepository extends JpaRepository<Produkt, Long> {
}
