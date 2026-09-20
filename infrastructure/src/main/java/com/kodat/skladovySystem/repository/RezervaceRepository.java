package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Rezervace;
import com.kodat.skladovysystem.interfaces.Irepository.IRezervaceRepository;

import java.util.List;

public class RezervaceRepository implements IRezervaceRepository {
    private final JpaRepositoryRezervace _rezervaceRepository;

    public RezervaceRepository(JpaRepositoryRezervace rezervaceRepository) {
        _rezervaceRepository = rezervaceRepository;
    }

    @Override
    public Rezervace najdiRezervaciPodleId(long id) {
        return _rezervaceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rezervace> dejRezervace() {
        return _rezervaceRepository.findAll();
    }

    @Override
    public void odeberRezervaci(long id) {
        _rezervaceRepository.deleteById(id);
    }

    @Override
    public void pridejRezervaci(Rezervace rezervace) {
        _rezervaceRepository.save(rezervace);
    }

    @Override
    public void upravRezervaci(Rezervace rezervace) {
        _rezervaceRepository.save(rezervace);
    }
}
