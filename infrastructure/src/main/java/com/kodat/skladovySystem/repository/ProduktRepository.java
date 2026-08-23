package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.entities.Produkt;
import com.kodat.skladovysystem.interfaces.Irepository.IProduktRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProduktRepository implements IProduktRepository {
    private final JpaProduktRepository _iproduktJpaRepository;

    public ProduktRepository(JpaProduktRepository _iproduktJpaRepository) {
        this._iproduktJpaRepository = _iproduktJpaRepository;
    }

    @Override
    public Produkt najdiPodleId(Long id) {
        return _iproduktJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produkt> najdiVsechny() {
        return _iproduktJpaRepository.findAll();
    }

    @Override
    public void odeberProduktpodleId(Long id) {
        Produkt produkt = _iproduktJpaRepository.findById(id).orElse(null);
        if(produkt == null) {
            _iproduktJpaRepository.deleteById(id);
        }
    }

    @Override
    public void pridej(Produkt produkt) {
        _iproduktJpaRepository.save(produkt);
    }

    @Override
    public Kategorie najdiKategoriiPodleId(long id) {
     return null;
    }


}
