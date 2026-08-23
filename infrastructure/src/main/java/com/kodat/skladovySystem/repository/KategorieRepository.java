package com.kodat.skladovySystem.repository;

import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.interfaces.Irepository.IKategorieRepository;
import org.springframework.stereotype.Repository;

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
    public Long najdiIdKategorie(Kategorie kategorie) {
        return _IKategorieJpaRepository.fi
    }


}
