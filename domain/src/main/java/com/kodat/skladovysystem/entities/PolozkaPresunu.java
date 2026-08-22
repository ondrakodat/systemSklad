package com.kodat.skladovysystem.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "polozka_presunu")
public class PolozkaPresunu extends Polozka{
    @ManyToOne
    @JoinColumn(name = "presun_id")
    private Presun presun;
}
