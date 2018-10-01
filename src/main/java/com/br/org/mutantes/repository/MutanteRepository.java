package com.br.org.mutantes.repository;

import com.br.org.mutantes.Entity.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutanteRepository extends JpaRepository<DNA, Long> {

    @Query("select count(d) from DNA d where d.mutante = ?1")
    int countByMutante(boolean b);
}
