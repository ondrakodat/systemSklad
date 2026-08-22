package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "polozka")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Polozka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(columnDefinition = "INTEGER DEFAULT 0")
    @PositiveOrZero
    protected int mnozstvi;
    @ManyToOne
    @JoinColumn(name="produkt_id")
    protected Produkt produkt;
}
