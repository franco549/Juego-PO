package simuladorDeTriageGuardiaMedica;

public class Paciente {
    private String dni;
    private String nombre;
    private Urgencia urgencia;

    public Paciente(String dni, String nombre, Urgencia urgencia) {
        this.dni = dni;
        this.nombre = nombre;
        this.urgencia = urgencia;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public Urgencia getUrgencia() { return urgencia; }

    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ") - Triage: " + urgencia;
    }
}
