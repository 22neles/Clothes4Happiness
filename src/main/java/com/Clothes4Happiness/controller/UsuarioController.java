package com.Clothes4Happiness.controller;

import com.Clothes4Happiness.models.Usuario;
import com.Clothes4Happiness.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get()); // Retorna o usuário encontrado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(Long.valueOf(id));

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDetails.getNome());
            // Você pode adicionar outras propriedades a serem atualizadas aqui

            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
