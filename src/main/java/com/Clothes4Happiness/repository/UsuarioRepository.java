package com.Clothes4Happiness.repository;

import com.Clothes4Happiness.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

