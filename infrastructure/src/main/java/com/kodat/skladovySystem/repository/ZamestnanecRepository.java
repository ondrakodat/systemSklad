package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Zamestnanec;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ZamestnanecRepository implements IZamestnanecRepository {
    private final JpaZamestnanecRepository _jpaZamestnanecRepository;

    public ZamestnanecRepository(JpaZamestnanecRepository jpaZamestnanecRepository) {
        _jpaZamestnanecRepository = jpaZamestnanecRepository;
    }

    @Override
    public Zamestnanec dejZamestnancePodleId(Long id) {
        return _jpaZamestnanecRepository.findById(id).orElse(null);
    }
}
