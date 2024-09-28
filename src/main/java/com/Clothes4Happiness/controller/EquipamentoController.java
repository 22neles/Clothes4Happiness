package com.Clothes4Happiness.controller;

import com.Clothes4Happiness.models.Equipamento;
import com.Clothes4Happiness.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping
    public List<Equipamento> getEquipamentos() {
        return equipamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable int id) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);

        if (equipamentoOptional.isPresent()) {
            return ResponseEntity.ok(equipamentoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Equipamento createEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> updateEquipamento(@PathVariable int id, @RequestBody Equipamento equipamentoDetails) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);

        if (equipamentoOptional.isPresent()) {
            Equipamento equipamento = equipamentoOptional.get();
            equipamento.setDescricao(equipamentoDetails.getDescricao());
            equipamento.setSituacao(equipamentoDetails.getSituacao());
            equipamento.setUsuario(equipamentoDetails.getUsuario()); // Vincular o usuário, se necessário

            Equipamento updatedEquipamento = equipamentoRepository.save(equipamento);
            return ResponseEntity.ok(updatedEquipamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable int id) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);

        if (equipamentoOptional.isPresent()) {
            equipamentoRepository.delete(equipamentoOptional.get());
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
