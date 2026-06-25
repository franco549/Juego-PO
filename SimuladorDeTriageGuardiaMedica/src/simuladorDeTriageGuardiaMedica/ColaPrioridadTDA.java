package simuladorDeTriageGuardiaMedica;

public interface ColaPrioridadTDA {
    void acolarPrioridad(Paciente p);
    void desacolar();
    Paciente obtenerPrimero();
    boolean colaVacia();
}
