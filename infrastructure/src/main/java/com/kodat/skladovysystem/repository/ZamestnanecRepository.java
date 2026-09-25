package com.kodat.skladovysystem.repository;

import com.kodat.skladovysystem.entities.Zamestnanec;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Zamestnanec> dejZamestnance() {
        return  _jpaZamestnanecRepository.findAll();
    }

    @Override
    public void odeberZamestnance(long id) {
        _jpaZamestnanecRepository.deleteById(id);
    }

    @Override
    public void upravZamestnance(Zamestnanec zamestnanec) {
        _jpaZamestnanecRepository.save(zamestnanec);
    }

    @Override
    public void pridejZamestnance(Zamestnanec zamestnanec) {
        _jpaZamestnanecRepository.save(zamestnanec);
    }

    @Override
    public List<Zamestnanec> najdiZamestnancePodleNazvu(String nazev) {
        return _jpaZamestnanecRepository.findByJmenoContainingIgnoreCaseOrPrijmeniContainingIgnoreCase(nazev, nazev);
    }

    @Override
    public Zamestnanec najdiPodleEmailu(String email) {
        return _jpaZamestnanecRepository.findByEmail(email);
    }

}
