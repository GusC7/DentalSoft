package com.example.dentalsoft.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.example.dentalsoft.modelo.enums.CondicionMedica;
import com.example.dentalsoft.modelo.enums.GrupoSanguineo;
import com.example.dentalsoft.modelo.enums.HabitoFumador;

import java.time.LocalDate;
import java.util.Date;
// Importante, usamos Set para las condiciones
import java.util.Set;
/**
 * Entidad Paciente que hereda de Persona.
 * Representa a los pacientes del sistema dental.
 * NO es un usuario del sistema, solo una persona registrada como paciente.
 */

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(name = "dni", nullable = false, unique = true, length = 20)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "obra_social", length = 100)
    private String obraSocial;
    
    // --- Datos para Cirugía (VITALES) ---
    @Column(name = "altura_cm")
    private Integer alturaCm; // Usamos Integer, no long. Altura en centímetros.
    
    @Column(name = "peso_kg")
    private Double pesoKg; // Double está bien para peso.
    
    @Enumerated(EnumType.STRING) // Guarda "A_POSITIVO" en la DB, no el número 0
    private GrupoSanguineo grupoSanguineo;

    @Enumerated(EnumType.STRING) // Guarda "FUMADOR" en la DB, no el número 0
    private HabitoFumador habitoFumador;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "paciente_condicion_medica", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "condicion_medica")
    @Enumerated(EnumType.STRING)    
    private Set<CondicionMedica> condicionesMedicas; // Usamos Set para evitar duplicados de condiciones. 
    // Esta línea permite que cada paciente tenga una lista de condiciones médicas (de tipo enum) guardadas en la base de datos y accesibles desde el modelo Java.

    // --- Historial Médico ---
    @Lob // Para texto largo
    private String alergiasConocidas; // Ej: "Penicilina, Látex"

    @Lob
    private String medicamentosActuales; // Ej: "Aspirina, Metformina"

    @Lob
    private String habitosSaludBucal; // Ej: "Cepillado diario, uso de hilo dental"

    // --- Contacto de Emergencia (Estructurado) ---
    private String contactoEmergenciaNombre;
    private String contactoEmergenciaTelefono;

    @PrePersist
    private void prePersist() {
        this.fechaAlta = LocalDate.now();
    }

}
