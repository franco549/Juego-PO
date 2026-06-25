package simuladorDeTriageGuardiaMedica;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {
    private NodoPaciente inicio;

    public ColaPrioridadDinamica() {
        this.inicio = null;
    }

    @Override
    public void acolarPrioridad(Paciente nuevoPaciente) {
        NodoPaciente nuevoNodo = new NodoPaciente(nuevoPaciente);
        
        // Caso 1: Cola vacía o el nuevo tiene mayor prioridad que el primero
        if (inicio == null || nuevoPaciente.getUrgencia().getValor() > inicio.paciente.getUrgencia().getValor()) {
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        } else {
            // Caso 2: Buscar la posición correcta según prioridad (Ordenamiento en la inserción)
            NodoPaciente actual = inicio;
            while (actual.siguiente != null && 
                   actual.siguiente.paciente.getUrgencia().getValor() >= nuevoPaciente.getUrgencia().getValor()) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            inicio = inicio.siguiente;
        }
    }

    @Override
    public Paciente obtenerPrimero() {
        if (colaVacia()) {
            return null;
        } else {
            return inicio.paciente;
        }
    }

    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}
