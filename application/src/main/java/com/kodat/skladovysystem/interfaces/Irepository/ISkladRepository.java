package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Sklad;

public interface ISkladRepository {
    Sklad najdiSkladPodleId(long id);
}
