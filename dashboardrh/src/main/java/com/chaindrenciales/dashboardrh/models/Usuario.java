package com.chaindrenciales.dashboardrh.models;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apellidos;
    private String email;
    private Boolean enabled;
    private Boolean estado_verificacion;
    private String hash_blockchain;
    private String lugar_nacimiento;
    private String nombre;
    private String password;
    private String perfil;
    private String puesto;
    private String rfc;
    private String telefono;
    private String username;
    private Long creado_por_id;
    private LocalDate fecha_registro;
    private Boolean perfil_completo;
    private Long empresa_id;
    private String avatar_blob_name;

    
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<UsuarioRol> usuarioRoles;

    // Helper
    public boolean tieneRol(String nombreRol) {
        if (usuarioRoles == null) return false;
        return usuarioRoles.stream()
                .anyMatch(ur -> ur.getRol() != null &&
                        nombreRol.equalsIgnoreCase(ur.getRol().getNombre_rol()));
    }

    

	// Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public Boolean getEstado_verificacion() { return estado_verificacion; }
    public void setEstado_verificacion(Boolean estado_verificacion) { this.estado_verificacion = estado_verificacion; }

    public String getHash_blockchain() { return hash_blockchain; }
    public void setHash_blockchain(String hash_blockchain) { this.hash_blockchain = hash_blockchain; }

    public String getLugar_nacimiento() { return lugar_nacimiento; }
    public void setLugar_nacimiento(String lugar_nacimiento) { this.lugar_nacimiento = lugar_nacimiento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Long getCreado_por_id() { return creado_por_id; }
    public void setCreado_por_id(Long creado_por_id) { this.creado_por_id = creado_por_id; }

    public LocalDate getFecha_registro() { return fecha_registro; }
    public void setFecha_registro(LocalDate fecha_registro) { this.fecha_registro = fecha_registro; }

    public Boolean getPerfil_completo() { return perfil_completo; }
    public void setPerfil_completo(Boolean perfil_completo) { this.perfil_completo = perfil_completo; }

    public Long getEmpresa_id() { return empresa_id; }
    public void setEmpresa_id(Long empresa_id) { this.empresa_id = empresa_id; }

    public String getAvatar_blob_name() { return avatar_blob_name; }
    public void setAvatar_blob_name(String avatar_blob_name) { this.avatar_blob_name = avatar_blob_name; }

    public Set<UsuarioRol> getUsuarioRoles() { return usuarioRoles; }
    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) { this.usuarioRoles = usuarioRoles; }
}
