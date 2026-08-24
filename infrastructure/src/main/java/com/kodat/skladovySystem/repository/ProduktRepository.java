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
        return _iproduktJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Produkt neexistuje"));
    }

    @Override
    public List<Produkt> najdiVsechny()
    {
        return _iproduktJpaRepository.findAll();
    }

    @Override
    public void odeberProduktpodleId(Long id) {
        Produkt produkt = _iproduktJpaRepository.findById(id).orElse(null);
        if(produkt != null) {
            _iproduktJpaRepository.deleteById(id);
        }
    }

    @Override
    public void pridej(Produkt produkt) {
        _iproduktJpaRepository.save(produkt);
    }



    @Override
    public void upravProdukt(Produkt produkt, long id) {
        Produkt p = _iproduktJpaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Produkt nebyl nalezen"));
        p.setNazev(produkt.getNazev());
        p.setCena(produkt.getCena());
        p.setPopis(produkt.getPopis());
        p.setKategorie(produkt.getKategorie());
        p.setMinimalniSkladovaneMnozstvi(produkt.getMinimalniSkladovaneMnozstvi());

        _iproduktJpaRepository.save(p);
    }


}
