package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "polozka_vydeje")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolozkaVydeje extends Polozka{
    @ManyToOne
    @JoinColumn(name = "vydej_id")
    private Vydej vydej;
}
