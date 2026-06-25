package simuladorDeTriageGuardiaMedica;

public interface DiccionarioTDA {
    void guardar(String clave, Paciente valor);
    Paciente obtener(String clave);
    boolean existeClave(String clave);
}
