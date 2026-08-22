package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pozice_skladu")
public class PoziceSkladu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String kod;
    @Column(length = 200, nullable = true)
    private String popis;
    @ManyToOne
    @JoinColumn(name = "sklad_id", nullable = false)
    private Sklad sklad;
}
