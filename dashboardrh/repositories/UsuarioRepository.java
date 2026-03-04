package com.chaindrenciales.dashboardrh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chaindrenciales.dashboardrh.models.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);
}
