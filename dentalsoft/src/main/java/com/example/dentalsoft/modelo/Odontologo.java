package com.example.dentalsoft.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad Odontólogo que hereda de Usuario.
 * Representa a los profesionales odontólogos del sistema.
 */
@Entity
@Table(name = "odontologo")
@DiscriminatorValue("ODONTOLOGO")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Odontologo extends Usuario {
    
    @Column(name = "numero_matricula", nullable = false, unique = true, length = 50)
    private String numeroMatricula;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "odontologo_especialidad",
        joinColumns = @JoinColumn(name = "odontologo_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private Set<Especialidad> especialidades = new HashSet<>();
    
    /**
     * Constructor personalizado para crear un odontólogo.
     */
    public Odontologo(String dni, String nombre, String apellido, String email, 
                      Date fechaNacimiento, String direccion, String contraseña, String numeroMatricula) {
        super(dni, nombre, apellido, email, fechaNacimiento, direccion, contraseña);
        this.numeroMatricula = numeroMatricula;
        this.especialidades = new HashSet<>();
    }
    
    /**
     * Constructor con especialidades.
     */
    public Odontologo(String dni, String nombre, String apellido, String email, 
                      Date fechaNacimiento, String direccion, String contraseña, 
                      String numeroMatricula, Set<Especialidad> especialidades) {
        super(dni, nombre, apellido, email, fechaNacimiento, direccion, contraseña);
        this.numeroMatricula = numeroMatricula;
        this.especialidades = especialidades != null ? especialidades : new HashSet<>();
    }
    
    /**
     * Método de utilidad para agregar una especialidad.
     */
    public void agregarEspecialidad(Especialidad especialidad) {
        if (this.especialidades == null) {
            this.especialidades = new HashSet<>();
        }
        this.especialidades.add(especialidad);
    }
    
    /**
     * Método de utilidad para remover una especialidad.
     */
    public void removerEspecialidad(Especialidad especialidad) {
        if (this.especialidades != null) {
            this.especialidades.remove(especialidad);
        }
    }
}