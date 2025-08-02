package com.vespertine.backend.dtoConverter;

import org.springframework.stereotype.Component;

import com.vespertine.backend.dto.UnidadeBasicaSaudeDTO;
import com.vespertine.backend.model.UnidadeBasicaSaude;

@Component
public class DTOConverter {

    public static UnidadeBasicaSaude toEntity(UnidadeBasicaSaudeDTO dto){
        UnidadeBasicaSaude unidadeBasicaSaude = new UnidadeBasicaSaude();
        unidadeBasicaSaude.setNome(dto.getNome());
        unidadeBasicaSaude.setLogradouro(dto.getLogradouro());
        unidadeBasicaSaude.setNumero(dto.getNumero());
        unidadeBasicaSaude.setBairro(dto.getBairro());
        unidadeBasicaSaude.setCidade(dto.getCidade());
        unidadeBasicaSaude.setEstado(dto.getEstado());
        unidadeBasicaSaude.setCep(dto.getCep());
        return unidadeBasicaSaude;
    }

    public static UnidadeBasicaSaudeDTO toDTO(UnidadeBasicaSaude unidadeBasicaSaude){
        UnidadeBasicaSaudeDTO dto = new UnidadeBasicaSaudeDTO();
        dto.setNome(unidadeBasicaSaude.getNome());
        dto.setLogradouro(unidadeBasicaSaude.getLogradouro());
        dto.setNumero(unidadeBasicaSaude.getNumero());
        dto.setBairro(unidadeBasicaSaude.getBairro());
        dto.setCidade(unidadeBasicaSaude.getCidade());
        dto.setEstado(unidadeBasicaSaude.getEstado());
        dto.setCep(unidadeBasicaSaude.getCep());
        return dto;

    }

}
