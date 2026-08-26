package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.interfaces.Irepository.IKategorieRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KategorieRepository implements IKategorieRepository {
    private final JpaKategorieRepository _IKategorieJpaRepository;

    public KategorieRepository(JpaKategorieRepository _IKategorieJpaRepository) {
        this._IKategorieJpaRepository = _IKategorieJpaRepository;
    }


    @Override
    public Kategorie najdiKategoriiPodleId(long id) {
     return _IKategorieJpaRepository.findById(id).orElse(null);
    }

    @Override
    public void pridejKategorii(Kategorie kategorie) {
        _IKategorieJpaRepository.save(kategorie);
    }

    @Override
    public void odeberKategorii(Long id) {
        _IKategorieJpaRepository.deleteById(id);
    }

    @Override
    public void upravKategorii(Kategorie kategorie) {
        _IKategorieJpaRepository.save(kategorie);
    }

    @Override
    public List<Kategorie> vypisKategorie() {
        return _IKategorieJpaRepository.findAll();
    }


}
