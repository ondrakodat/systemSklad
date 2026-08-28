package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.interfaces.Irepository.ISkladRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SkladRepository implements ISkladRepository {
    private final JpaSkladRepository _SkladRepository;

    public SkladRepository(JpaSkladRepository skladRepository) {
        _SkladRepository = skladRepository;
    }

    @Override
    public Sklad najdiSkladPodleId(long id) {
        return _SkladRepository.findById(id).orElse(null);
    }
}
