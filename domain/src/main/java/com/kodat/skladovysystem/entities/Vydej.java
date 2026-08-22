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
    private String cisloVydaje;
    private LocalDateTime datum;
    private String poznamka;
    @ManyToOne
    private Sklad sklad;
    @ManyToOne
    private Zamestnanec zamestnanec;
    @OneToMany(mappedBy = "prijem", cascade = CascadeType.ALL)
    private List<PolozkaVydeje> polozkyVydaje = new ArrayList<>();


}
