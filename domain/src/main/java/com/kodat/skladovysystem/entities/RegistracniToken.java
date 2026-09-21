package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RegistracniToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String token;
    @Column(nullable = false)
    private LocalDateTime platnostDo;
    @OneToOne
    private Zamestnanec zamestnanec;

}
