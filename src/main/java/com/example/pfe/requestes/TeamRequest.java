package com.example.pfe.requestes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamRequest {
    private String name;
    private List<String> students_emails;
    private Integer classement;
}
