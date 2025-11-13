package com.example.dentalsoft.modelo;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entidad Administrador que hereda de Usuario.
 * Representa a los administradores del sistema.
 */
@Entity
@Table(name = "administrador")
@DiscriminatorValue("ADMIN")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario {
    
    @PrePersist
    @PreUpdate
    private void validarAdministrador() {
        if (this.getRoles() == null || this.getRoles().isEmpty()) {
            this.setRoles(Set.of(new Rol(Rol.ROLE_ADMIN))); // Rol por defecto: ROLE_ADMIN
        }
    }
    
    /**
     * Constructor personalizado para crear un administrador.
     */
    public Administrador(String dni, String nombre, String apellido, String email, 
                        Date fechaNacimiento, String direccion, String contraseña) {
        super(dni, nombre, apellido, email, fechaNacimiento, direccion, contraseña);
    }
}
