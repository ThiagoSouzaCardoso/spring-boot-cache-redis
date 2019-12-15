package br.com.empresa.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class CompanyInput {

    private String name;

    public CompanyInput() {
        super();
    }

    public CompanyInput(String name) {
        this.name = name;
    }
}
