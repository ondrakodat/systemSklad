package com.kodat.skladovysystem.interfaces.IsecretService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecretHashService implements ISecretHashService{
    private final PasswordEncoder encoder;

    public SecretHashService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String vytvorHeslo(String heslo) {
        String hesloHash = encoder.encode(heslo);
        if(hesloHash == null)
            return "Chyba při hashování hesla";
        return hesloHash;
    }

    @Override
    public boolean overHeslo(String rawHeslo, String hashHeslo) {
        return encoder.matches(rawHeslo, hashHeslo);
    }
}
