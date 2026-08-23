package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vydej")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vydej {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cisloVydaje;
    @Column(nullable = false)
    private LocalDateTime datum;
    @Column(length = 200)
    private String poznamka;
    @ManyToOne
    private Sklad sklad;
    @ManyToOne
    private Zamestnanec zamestnanec;
    @OneToMany(mappedBy = "vydej", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PolozkaVydeje> polozkyVydaje = new ArrayList<>();


}
