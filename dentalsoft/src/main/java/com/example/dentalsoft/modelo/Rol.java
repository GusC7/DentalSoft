package com.example.dentalsoft.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa los roles del sistema.
 * Ejemplos: ROLE_ADMIN, ROLE_ODONTOLOGO, etc.
 */
@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    
    // Constantes para los nombres de roles
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_ODONTOLOGO = "ROLE_ODONTOLOGO";
    public static final String ROLE_RECEPCIONISTA = "ROLE_RECEPCIONISTA";
    public static final String ROLE_ASISTENTE_ODONTOLOGICO = "ROLE_ASISTENTE_ODONTOLOGICO";
    public static final String ROLE_MECANICO_DENTAL = "ROLE_MECANICO_DENTAL";
    public static final String ROLE_PACIENTE = "ROLE_PACIENTE";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;
    
    /**
     * Constructor de conveniencia para crear un rol con solo el nombre.
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}