package com.kodat.skladovysystem.repository;

import com.kodat.skladovysystem.entities.Zamestnanec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaZamestnanecRepository extends JpaRepository<Zamestnanec, Long> {

    List<Zamestnanec> findByJmenoContainingIgnoreCaseOrPrijmeniContainingIgnoreCase(String jmeno, String prijmeni);

}
