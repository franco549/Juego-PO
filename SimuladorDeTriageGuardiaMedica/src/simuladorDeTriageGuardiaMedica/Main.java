package simuladorDeTriageGuardiaMedica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE TRIAGE HOSPITALARIO ===");
        
        // se crea la guardia con un recurso estático inicial de 2 camas
        SistemaTriage centroMedico = new SistemaTriage(2);

        // llega Carlos en ambulancia con dolor de pecho (ROJO)
        centroMedico.registrarIngresoPaciente("3333", "Carlos", Urgencia.ROJO);
        // llega Juan por un esguince menor (VERDE)
        centroMedico.registrarIngresoPaciente("1111", "Juan", Urgencia.VERDE);
        // llega María con dificultad respiratoria severa (ROJO)
        centroMedico.registrarIngresoPaciente("4444", "María", Urgencia.ROJO);
        // llega Ana con fiebre alta (AMARILLO)
        centroMedico.registrarIngresoPaciente("2222", "Ana", Urgencia.AMARILLO);

        // primero se lo atiende a Carlos debido a que tiene máxima prioridad y es el primero en llegar
        Paciente p1 = centroMedico.atenderProximo();
        centroMedico.asignarCamaAAtendido(p1);

        // segundo se la atiende a María debido a que tiene máxima prioridad
        Paciente p2 = centroMedico.atenderProximo();
        centroMedico.asignarCamaAAtendido(p2);

        // tercero se la atiende a Ana debido a que tiene prioridad intermedia
        Paciente p3 = centroMedico.atenderProximo();
        centroMedico.asignarCamaAAtendido(p3); // alerta de que ya no hay mas camas (solo hay dos)

        // se busca pacientes en el historial con el DNI como clave
        centroMedico.consultarHistorial("4444");
        centroMedico.consultarHistorial("9999"); // este paciente no existe

        centroMedico.deshacerUltimaAtencion(); // cancela la atención de Ana y la re-acola
    }
}
