package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
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
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @PositiveOrZero
    private int fyzickeMnozstvi;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @PositiveOrZero
    private int rezervovaneMnozstvi;
    @ManyToOne
    @JoinColumn(name = "produkt_id", nullable = false)
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name = "sklad_id", nullable = false)
    private Sklad sklad;
    @ManyToOne
    @JoinColumn(name = "poziceSkladu_id", nullable = false)
    private PoziceSkladu poziceSkladu;
}
