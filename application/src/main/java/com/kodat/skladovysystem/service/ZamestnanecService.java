package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;

public class ZamestnanecService implements IZamestnanecService {
    private final IZamestnanecRepository _IZamestnaecRepository;

    public ZamestnanecService(IZamestnanecRepository iZamestnaecRepository) {
        _IZamestnaecRepository = iZamestnaecRepository;
    }

    @Override
    public ZamestnanecDto dejZamestnanceDtoPodleId(long id) {
        ZamestnanecDto dto = new ZamestnanecDto();
        return dto;
    }
}
