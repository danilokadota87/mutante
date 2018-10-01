package com.br.org.mutantes.controller;

import com.br.org.mutantes.Entity.DNA;
import com.br.org.mutantes.dto.DNADTO;
import com.br.org.mutantes.dto.EstatisticasDTO;
import com.br.org.mutantes.repository.MutanteRepository;
import com.br.org.mutantes.service.MutantesService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/")
public class MutantesController {

    private final MutantesService mutantesService;

    private final MutanteRepository mutanteRepository;

    @Autowired
    public MutantesController(MutantesService mutantesService, MutanteRepository mutanteRepository) {
        this.mutantesService = mutantesService;
        this.mutanteRepository = mutanteRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "mutante/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String isMutante(@RequestBody DNADTO dnadto) throws AccessDeniedException {
        if (mutantesService.isMutante(dnadto.getDna())) {
            DNA dna = new DNA();
            dna.setDna(StringUtils.join(dnadto.getDna()));
            dna.setMutante(true);
            mutanteRepository.save(dna);
        } else {
            DNA dna = new DNA();
            dna.setDna(StringUtils.join(dnadto.getDna()));
            dna.setMutante(false);
            mutanteRepository.save(dna);
        }
        return mutantesService.isMutante(dnadto.getDna()) ? "200 - OK" : "403-Proibido";
    }

    @RequestMapping(method = RequestMethod.GET, value = "estatisticas/")
    @ResponseBody
    public EstatisticasDTO estatisticas() {

        return new EstatisticasDTO(mutanteRepository.countByMutante(true), mutanteRepository.countByMutante(false));
    }
}


