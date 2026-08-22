package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prijem")
public class Prijem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cisloPrijmu;
    @Column(nullable = false)
    private LocalDateTime datum;
    @Column(nullable = false)
    private String dodavatel;
    private String poznamka;
    @ManyToOne
    @JoinColumn(name = "sklad_id")
    private Sklad sklad;
    @ManyToOne
    @JoinColumn(name = "zamestnanec_id")
    private Zamestnanec zamestnanec;
    @OneToMany(mappedBy = "prijem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PolozkaPrijmu> polozkyPrijmu;

}
