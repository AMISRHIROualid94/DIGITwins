package com.sf.digitwins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResponse {

    private String nom;
    private String prenom;
    private String fonction;
}
