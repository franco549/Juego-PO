package simuladorDeTriageGuardiaMedica;

public class Cama {
    private int numero;
    private Paciente pacienteAsignado;
    private boolean ocupada;

    public Cama(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public int getNumero() { return numero; }
    public Paciente getPacienteAsignado() { return pacienteAsignado; }
    public boolean isOcupada() { return ocupada; }

    public void asignarPaciente(Paciente p) {
        this.pacienteAsignado = p;
        this.ocupada = true;
    }

    public void liberar() {
        this.pacienteAsignado = null;
        this.ocupada = false;
    }
}
