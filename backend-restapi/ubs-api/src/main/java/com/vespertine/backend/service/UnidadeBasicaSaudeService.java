package com.vespertine.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vespertine.backend.dto.UnidadeBasicaSaudeDTO;
import com.vespertine.backend.dtoConverter.DTOConverter;
import com.vespertine.backend.model.UnidadeBasicaSaude;
import com.vespertine.backend.repository.UnidadeBasicaSaudeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UnidadeBasicaSaudeService {

    @Autowired
    private UnidadeBasicaSaudeRepository repository;


    public List<UnidadeBasicaSaudeDTO> getAll(){
        List<UnidadeBasicaSaude> unidadesBS = repository.findAll();
        if (unidadesBS.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma unidade básica de saúde encontrada.");
        }
        return unidadesBS.stream()
            .map(DTOConverter::toDTO)
            .collect(Collectors.toList());
    }

    public UnidadeBasicaSaudeDTO getUnidadeById(Long id){
        Optional<UnidadeBasicaSaude> unidadeBS = repository.findById(id);
        return unidadeBS.map(DTOConverter::toDTO).orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada com id: " + id));
    }

    public UnidadeBasicaSaudeDTO createUnidadeBS(UnidadeBasicaSaudeDTO dto){
        UnidadeBasicaSaude unidade = repository.findByNome(dto.getNome())
            .orElseGet(() -> repository.save(DTOConverter.toEntity(dto)));
        
            return DTOConverter.toDTO(unidade);
    }

    public UnidadeBasicaSaudeDTO delete(Long id){
        return repository.findById(id)
            .map(unidadeBS -> {
                repository.delete(unidadeBS);
                return DTOConverter.toDTO(unidadeBS);
            })
            .orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada com id: " + id));
        
    }

}
