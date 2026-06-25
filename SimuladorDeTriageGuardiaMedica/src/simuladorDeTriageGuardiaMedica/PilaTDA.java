package simuladorDeTriageGuardiaMedica;

public interface PilaTDA {
    void apilar(Paciente p);
    void desapilar();
    Paciente obtenerTope();
    boolean pilaVacia();
}
