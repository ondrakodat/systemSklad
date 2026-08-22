package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="inventar")
public class Inventar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fyzickeMnozstvi;
    private int rezervovaneMnozstvi;
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name = "sklad_id")
    private Sklad sklad;
    @ManyToOne
    @JoinColumn(name = "poziceSkladu_id")
    private PoziceSkladu poziceSkladu;
}
