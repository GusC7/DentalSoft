package com.example.dentalsoft.modelo;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Clase que representa a un recepcionista en el sistema dental.
 */
@Entity
@Table(name = "recepcionista")
@DiscriminatorValue("RECEPCIONISTA")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Recepcionista extends Usuario {
    
    /**
     * Constructor personalizado para crear un recepcionista.
     */
    public Recepcionista(String dni, String nombre, String apellido, String email, 
                        Date fechaNacimiento, String direccion, String contraseña) {
        super(dni, nombre, apellido, email, fechaNacimiento, direccion, contraseña);
    }
}
