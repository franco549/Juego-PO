package simuladorDeTriageGuardiaMedica;

public class PilaDinamica implements PilaTDA {
    private NodoPaciente tope;

    public PilaDinamica() {
        this.tope = null;
    }

    @Override
    public void apilar(Paciente p) {
        NodoPaciente nuevo = new NodoPaciente(p);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            tope = tope.siguiente;
        }
    }

    @Override
    public Paciente obtenerTope() {
        if (pilaVacia()) {
            return null;
        } else {
            return tope.paciente;
        }
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }
}
