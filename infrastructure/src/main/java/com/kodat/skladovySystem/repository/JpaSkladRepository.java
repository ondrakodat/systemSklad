package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Sklad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSkladRepository extends JpaRepository<Sklad, Long> {
}
