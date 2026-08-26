package com.kodat.skladovysystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KategorieDto {
    private Long id;
    private String nazev;
    private Long nadKategorie;
}
