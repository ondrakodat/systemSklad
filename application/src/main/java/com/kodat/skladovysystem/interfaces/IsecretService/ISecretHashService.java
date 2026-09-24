package com.kodat.skladovysystem.interfaces.IsecretService;

public interface ISecretHashService {
    public String vytvorHeslo(String heslo);
    public boolean overHeslo(String rawHeslo, String hashHeslo);
}
