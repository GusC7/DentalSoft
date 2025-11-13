package com.example.dentalsoft.modelo.enums;
public enum TipoUsuario {
    ADMIN("Administrador"),
    ODONTOLOGO("Odontólogo"),
    PACIENTE("Paciente"),
    RECEPCIONISTA("Recepcionista"),
    ASISTENTE_ODONTOLOGICO("Asistente Odontológico"),
    MECANICO_DENTAL("Mecánico Dental");

    private final String valor;

    TipoUsuario(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoUsuario fromValor(String valor) {
        for (TipoUsuario tipo : values()) {
            if (tipo.getValor().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de usuario no válido: " + valor);
    }
}