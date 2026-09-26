package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zamestnanec")
public class Zamestnanec implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String jmeno;
    @Column(nullable = false, length = 50)
    private String prijmeni;
    @Column(unique = true, length = 100)
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String heslo;
    private boolean aktivni;
    @Column(name = "profilova_fotka")
    private String profilovaFotka;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Role_" + role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return heslo;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
