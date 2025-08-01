package com.vespertine.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vespertine.backend.dto.UnidadeBasicaSaudeDTO;
import com.vespertine.backend.service.UnidadeBasicaSaudeService;

import jakarta.validation.Valid;

@RestController
public class UnidadeBasicaSaudeController {

    @Autowired
    private UnidadeBasicaSaudeService unidadeService;

    @GetMapping("/unidades")
    public List<UnidadeBasicaSaudeDTO> getUnidades(){
        return unidadeService.getAll();
    }

    @GetMapping("/unidade/{id}")
    public UnidadeBasicaSaudeDTO getUnidadeId(@PathVariable Long id){
        return unidadeService.getUnidadeById(id);
    }

    @PostMapping("/unidade")
    public UnidadeBasicaSaudeDTO newUnidade(@Valid @RequestBody UnidadeBasicaSaudeDTO dto){
        return unidadeService.createUnidadeBS(dto);
    }

    @DeleteMapping("/unidade/{id}")
    public UnidadeBasicaSaudeDTO delete(@PathVariable Long id){
        return unidadeService.delete(id);
    }

}
