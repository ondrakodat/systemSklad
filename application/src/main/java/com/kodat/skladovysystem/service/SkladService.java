package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.SkladDto;
import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.interfaces.Irepository.ISkladRepository;
import com.kodat.skladovysystem.interfaces.Iservices.ISkladService;
import org.springframework.stereotype.Service;

@Service
public class SkladService implements ISkladService {
    private final ISkladRepository _IskladRepository;

    public SkladService(ISkladRepository iskladRepository) {
        _IskladRepository = iskladRepository;
    }

    @Override
    public SkladDto dejSkladPodleId(long id) {
        SkladDto dto = new SkladDto();
        return dto;
    }
}
