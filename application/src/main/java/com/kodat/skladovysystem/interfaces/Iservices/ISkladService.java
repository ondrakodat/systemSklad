package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.SkladDto;
import com.kodat.skladovysystem.entities.Sklad;

public interface ISkladService {
    SkladDto dejSkladPodleId(long id);
}
