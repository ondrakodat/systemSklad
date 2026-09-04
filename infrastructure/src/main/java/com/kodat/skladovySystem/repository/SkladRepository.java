package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.interfaces.Irepository.ISkladRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Sklad> dejSklady() {
        return _SkladRepository.findAll();
    }

    @Override
    public void odeberSklad(long id) {
        _SkladRepository.deleteById(id);
    }

    @Override
    public void pridejSklad(Sklad sklad) {
        _SkladRepository.save(sklad);
    }

    @Override
    public void upravSklad(Sklad sklad) {
        _SkladRepository.save(sklad);
    }

    @Override
    public List<Sklad> najdiSkladyPodleNazvu(String nazev) {
        return _SkladRepository.findByNazevContainingNazevIgnoreCase(nazev);
    }
}
