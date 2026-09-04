package com.kodat.skladovysystem.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZamestnanecDto {
    private long id;
    private String jmeno;
    private String prijmeni;
    private String email;
}
