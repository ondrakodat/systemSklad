package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.StavRezervace;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
    @Column(nullable = false, unique = true)
    private String cisloObjednavky;
    @Column(columnDefinition = "INTEGER DEFAULT 0")
    @Positive
    private int mnozstvi;
    @Enumerated(EnumType.STRING)
    private StavRezervace stav;
    @ManyToOne
    @JoinColumn(name = "produkt_id", nullable = false)
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name = "sklad_id", nullable = false)
    private Sklad sklad;

}
