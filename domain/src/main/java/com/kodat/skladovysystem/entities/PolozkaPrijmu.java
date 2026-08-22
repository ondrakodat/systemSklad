package com.kodat.skladovysystem.entities;


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
@Table(name = "polozka_prijmu")
public class PolozkaPrijmu extends Polozka{
    @ManyToOne
    @JoinColumn(name = "prijem_id", nullable = false)
    private Prijem prijem;

}
