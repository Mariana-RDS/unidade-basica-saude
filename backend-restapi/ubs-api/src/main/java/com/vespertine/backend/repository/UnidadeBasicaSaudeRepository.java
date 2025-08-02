package com.vespertine.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vespertine.backend.model.UnidadeBasicaSaude;

@Repository
public interface UnidadeBasicaSaudeRepository extends JpaRepository<UnidadeBasicaSaude, Long>{
    Optional<UnidadeBasicaSaude> findByNome(String nome);

}
