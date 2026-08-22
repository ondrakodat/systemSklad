package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.StavRezervace;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rezervace")
public class Rezervace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cisloObjednavky;
    private int mnozstvi;
    @Enumerated(EnumType.STRING)
    private StavRezervace stav;
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name = "sklad_id")
    private Sklad sklad;

}
