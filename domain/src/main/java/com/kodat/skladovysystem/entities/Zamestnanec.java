package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zamestnanec")
public class Zamestnanec {
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
}
