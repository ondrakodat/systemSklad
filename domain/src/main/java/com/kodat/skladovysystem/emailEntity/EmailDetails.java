package com.kodat.skladovysystem.emailEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String prijemce;
    private String teloZpravy;
    private String predmetZpravy;
    private String priloha;
}