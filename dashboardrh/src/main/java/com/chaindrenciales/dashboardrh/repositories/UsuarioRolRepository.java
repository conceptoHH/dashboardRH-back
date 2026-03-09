/*package com.chaindrenciales.vinculacion.repositories;

import com.chaindrenciales.vinculacion.models.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    // Obtiene todos los roles de un usuario
    @Query("SELECT ur FROM UsuarioRol ur WHERE ur.usuario.id = :usuarioId")
    List<UsuarioRol> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    // Valida si un usuario tiene un rol específico
    @Query("SELECT CASE WHEN COUNT(ur) > 0 THEN true ELSE false END " +
           "FROM UsuarioRol ur JOIN ur.rol r " +
           "WHERE ur.usuario.id = :usuarioId AND r.nombre_rol = :rolNombre")
    boolean existsByUsuarioIdAndRolNombre(
    		@Param("usuarioId") Long usuarioId, 
    		@Param("rolNombre") String rolNombre
    	);
}
*/

package com.chaindrenciales.dashboardrh.repositories;

import com.chaindrenciales.dashboardrh.models.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    // Obtiene todos los roles de un usuario
    @Query("SELECT ur FROM UsuarioRol ur WHERE ur.usuario.id = :usuarioId")
    List<UsuarioRol> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    // Valida si un usuario tiene un rol específico
    @Query("SELECT CASE WHEN COUNT(ur) > 0 THEN true ELSE false END " +
           "FROM UsuarioRol ur JOIN ur.rol r " +
           "WHERE ur.usuario.id = :usuarioId AND r.nombre_rol = :rolNombre")
    boolean existsByUsuarioIdAndRolNombre(
    		@Param("usuarioId") Long usuarioId, 
    		@Param("rolNombre") String rolNombre
    	);
}

