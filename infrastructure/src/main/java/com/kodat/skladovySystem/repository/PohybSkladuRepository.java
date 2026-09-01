package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.PohybSkladu;
import com.kodat.skladovysystem.interfaces.Irepository.IPohybSkladuRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PohybSkladuRepository implements IPohybSkladuRepository {
    private final JpaPohybSkladuRepository _jpaPohybSkladuRepository;

    public PohybSkladuRepository(JpaPohybSkladuRepository _jpaPohybSkladuRepository) {
        this._jpaPohybSkladuRepository = _jpaPohybSkladuRepository;
    }

    @Override
    public PohybSkladu vypisPohybPodleId(Long id) {
        return _jpaPohybSkladuRepository.findById(id).orElse(null);
    }

    @Override
    public void odeberPohybSkladuPodleId(Long id) {
        _jpaPohybSkladuRepository.deleteById(id);
    }

    @Override
    public void upravPohybSkladu(PohybSkladu pohyb) {
        _jpaPohybSkladuRepository.save(pohyb);
    }

    @Override
    public List<PohybSkladu> vypisPohybySkladu() {
        return _jpaPohybSkladuRepository.findAll();
    }

    @Override
    public void vytvorPohybSkladu(PohybSkladu pohyb) {
        _jpaPohybSkladuRepository.save(pohyb);
    }
}
