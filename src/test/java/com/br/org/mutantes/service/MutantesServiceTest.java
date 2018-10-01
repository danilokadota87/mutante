
package com.br.org.mutantes.service;

import com.br.org.mutantes.Entity.DNA;
import com.br.org.mutantes.repository.MutanteRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MutantesServiceTest {


    @Mock
    private MutanteRepository mutanteRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void dnaIsMutanteHorizontal() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("ASRSSR");
        dnaList.add("SDASSA");
        dnaList.add("FFSRWG");
        dnaList.add("FDSSSS");
        MutantesService mutantesService = new MutantesService();
        DNA dna = new DNA();
        dna.setDna(StringUtils.join(dnaList));
        dna.setMutante(true);
        Mockito.when(mutanteRepository.save(dna)).thenReturn(dna);
        Boolean isMutante = mutantesService.isMutante(dnaList);
        Assert.assertTrue(isMutante);

    }

    @Test
    public void dnaIsMutanteVetical() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("ASRSSR");
        dnaList.add("SDASSR");
        dnaList.add("FFSRWR");
        dnaList.add("FDSSSR");
        MutantesService mutantesService = new MutantesService();
        DNA dna = new DNA();
        dna.setDna(StringUtils.join(dnaList));
        dna.setMutante(true);
        Mockito.when(mutanteRepository.save(dna)).thenReturn(dna);
        Boolean isMutante = mutantesService.isMutante(dnaList);
        Assert.assertTrue(isMutante);

    }

    @Test
    public void dnaIsMutanteDiagonalDesc() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("ASRSSR");
        dnaList.add("SAASSA");
        dnaList.add("FFARWG");
        dnaList.add("FDSASS");
        MutantesService mutantesService = new MutantesService();
        DNA dna = new DNA();
        dna.setDna(StringUtils.join(dnaList));
        dna.setMutante(true);
        Mockito.when(mutanteRepository.save(dna)).thenReturn(dna);
        Boolean isMutante = mutantesService.isMutante(dnaList);
        Assert.assertTrue(isMutante);

    }

    @Test
    public void dnaIsMutanteDiagonalASC() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("RSRSSR");
        dnaList.add("SAASRA");
        dnaList.add("FFARWG");
        dnaList.add("FDRASS");
        MutantesService mutantesService = new MutantesService();
        DNA dna = new DNA();
        dna.setDna(StringUtils.join(dnaList));
        dna.setMutante(true);
        Mockito.when(mutanteRepository.save(dna)).thenReturn(dna);
        Boolean isMutante = mutantesService.isMutante(dnaList);
        Assert.assertTrue(isMutante);

    }


    @Test
    public void dnaNoIsMutante() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("RSRSSK");
        dnaList.add("SAASRA");
        dnaList.add("FFARWG");
        dnaList.add("FDRASS");
        MutantesService mutantesService = new MutantesService();
        DNA dna = new DNA();
        dna.setDna(StringUtils.join(dnaList));
        dna.setMutante(true);
        Mockito.when(mutanteRepository.save(dna)).thenReturn(dna);
        Boolean isMutante = mutantesService.isMutante(dnaList);
        Assert.assertTrue(!isMutante);

    }

}
