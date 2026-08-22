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
    private String cisloPrijmu;
    private LocalDateTime datum;
    private String dodavatel;
    private String poznamka;
    @ManyToOne
    private Sklad sklad;
    @ManyToOne
    private Zamestnanec zamestnanec;
    @OneToMany(mappedBy = "prijem", cascade = CascadeType.ALL)
    private List<PolozkaPrijmu> polozkyPrijmu;

}
