package simuladorDeTriageGuardiaMedica;

class NodoPaciente {
    Paciente paciente;
    NodoPaciente siguiente;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }
}
