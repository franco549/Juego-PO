package simuladorDeTriageGuardiaMedica;

public class SistemaTriage {
    private ColaPrioridadTDA salaDeEspera;
    private DiccionarioTDA historialClinico;
    private PilaTDA historicoAtenciones;
    private Cama[] camasGuardia;

    public SistemaTriage(int cantidadCamas) {
        this.salaDeEspera = new ColaPrioridadDinamica();
        this.historialClinico = new DiccionarioDinamico();
        this.historicoAtenciones = new PilaDinamica();
        
        this.camasGuardia = new Cama[cantidadCamas];
        for (int i = 0; i < cantidadCamas; i++) {
            camasGuardia[i] = new Cama(i + 1);
        }
    }

    public void registrarIngresoPaciente(String dni, String nombre, Urgencia urgencia) {
        Paciente paciente = new Paciente(dni, nombre, urgencia);
        salaDeEspera.acolarPrioridad(paciente);
        historialClinico.guardar(dni, paciente);
        System.out.println("[INGRESO] " + paciente.getNombre() + " ingresado a sala de espera con prioridad " + urgencia);
    }

    public Paciente atenderProximo() {
        if (salaDeEspera.colaVacia()) {
            System.out.println("[INFO] No hay pacientes en la sala de espera.");
            return null;
        }
        Paciente proximo = salaDeEspera.obtenerPrimero();
        salaDeEspera.desacolar();
        historicoAtenciones.apilar(proximo);
        System.out.println("[ATENCIÓN] Atendiendo a: " + proximo.getNombre() + " por orden de Triage.");
        return proximo;
    }

    public void asignarCamaAAtendido(Paciente p) {
        if (p == null) return;
        for (int i = 0; i < camasGuardia.length; i++) {
            if (!camasGuardia[i].isOcupada()) {
                camasGuardia[i].asignarPaciente(p);
                System.out.println("[CAMAS] Paciente " + p.getNombre() + " asignado a Cama N° " + camasGuardia[i].getNumero());
                return;
            }
        }
        
        System.out.println("[ALERTA] No hay camas disponibles para el paciente " + p.getNombre());
    }

    public void consultarHistorial(String dni) {
        System.out.println("[CONSULTA DICCIONARIO] Buscando DNI: " + dni);
        if (historialClinico.existeClave(dni)) {
            Paciente p = historialClinico.obtener(dni);
            System.out.println("  -> Encontrado: " + p);
        } else {
            System.out.println("  -> El paciente no registra ingresos previos.");
        }
    }

    public void deshacerUltimaAtencion() {
        if (!historicoAtenciones.pilaVacia()) {
            Paciente cancelado = historicoAtenciones.obtenerTope();
            historicoAtenciones.desapilar();
            salaDeEspera.acolarPrioridad(cancelado);
            System.out.println("[DESHACER] Se canceló la atención de " + cancelado.getNombre() + ". Regresa a la cola.");
        }
    }
}
