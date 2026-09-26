package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ZamestnanecDetailService implements UserDetailsService {
    private final IZamestnanecRepository _repository;

    public ZamestnanecDetailService(IZamestnanecRepository repository) {
        _repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return _repository.najdiPodleEmailu(username);
    }
}
