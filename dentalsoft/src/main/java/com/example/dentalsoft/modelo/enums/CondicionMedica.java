package com.example.dentalsoft.modelo.enums;

public enum CondicionMedica {
    DIABETES,
    HIPERTENSION,
    ASMA,
    ALERGIAS,
    ENFERMEDADES_CARDIACAS,
    PROBLEMAS_RESPIRATORIOS, // Ej. Asma, EPOC
    TRASTORNOS_COAGULACION, // Ej. Hemofilia
    ENFERMEDAD_RENAL,
    ENFERMEDAD_HEPATICA,
    ALERGIA_MEDICAMENTOS,
    ALERGIA_LATEX,
    OTRA // Para la condición "tieneOtrasCondicionesMedicas"
    //probablemente se necesite un alta y baja en la base de datos para detallar
    // los casos de otras condiciones médicas
}
