package com.example.dentalsoft.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa las especialidades odontológicas.
 * Un odontólogo puede tener una o muchas especialidades.
 */
@Entity
@Table(name = "especialidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long id;
    
    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
    
    /**
     * Constructor de conveniencia para crear una especialidad con solo el nombre.
     */
    public Especialidad(String nombre) {
        this.nombre = nombre;
        this.activo = true;
    }
    
    /**
     * Constructor con nombre y descripción.
     */
    public Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = true;
    }
}