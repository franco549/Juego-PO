package simuladorDeTriageGuardiaMedica;

public enum Urgencia {
    ROJO(3),      // Emergencia extrema (Riesgo de vida)
    AMARILLO(2),  // Urgencia moderada
    VERDE(1);     // Consulta general

    private final int valor;

    Urgencia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
