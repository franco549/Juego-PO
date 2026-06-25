package simuladorDeTriageGuardiaMedica;

public class DiccionarioDinamico implements DiccionarioTDA {
    private NodoPaciente inicio;

    @Override
    public void guardar(String clave, Paciente valor) {
        if (existeClave(clave)) {
            NodoPaciente actual = inicio;
            while (actual != null) {
                if (actual.paciente.getDni().compareTo(clave) == 0) {
                    actual.paciente = valor;
                    return;
                }
                actual = actual.siguiente;
            }
        } else {
            NodoPaciente nuevo = new NodoPaciente(valor);
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    @Override
    public Paciente obtener(String clave) {
        NodoPaciente actual = inicio;
        while (actual != null) {
            if (actual.paciente.getDni().compareTo(clave) == 0) {
                return actual.paciente;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean existeClave(String clave) {
        NodoPaciente actual = inicio;
        while (actual != null) {
            if (actual.paciente.getDni().compareTo(clave) == 0) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}