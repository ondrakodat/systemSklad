package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.StavPresunu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "presun")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Presun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cisloPresunu;
    private LocalDateTime datum;
    @Enumerated(EnumType.STRING)
    private StavPresunu stav;
    @ManyToOne
    @JoinColumn(name="zdrojovy_sklad_id")
    private Sklad zdrojovySklad;
    @ManyToOne
    @JoinColumn(name="cilovy_sklad_id")
    private Sklad cilovySklad;
    @ManyToOne
    @JoinColumn(name="zamestnanec_id")
    private Zamestnanec zamestnanec;
    @OneToMany(mappedBy="presun", cascade = CascadeType.ALL)
    private List<PolozkaPresunu> polozky = new ArrayList<>();
}
