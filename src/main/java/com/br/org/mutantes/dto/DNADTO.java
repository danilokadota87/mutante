package com.br.org.mutantes.dto;

import java.util.ArrayList;
import java.util.List;

public class DNADTO {

    private List<String> dna = new ArrayList<>();

    public DNADTO(List<String> dna) {
        this.dna = dna;
    }

    public DNADTO() {
    }

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
