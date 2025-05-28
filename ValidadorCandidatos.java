
import java.util.ArrayList;
import java.util.List;
public class ValidadorCandidatos {
    private final String CANDIDATOS = "Candidatos";
    private List<String> candidatos;

    public ValidadorCandidatos() {
        this.candidatos = new ArrayList<>();
    }

    public void agregarCandidato(String candidato) {
        if (candidato != null && !candidato.trim().isEmpty()) {
            candidatos.add(candidato.trim());
        }
    }

    public List<String> obtenerCandidatos() {
        return new ArrayList<>(candidatos);
    }

    public boolean esValido(String candidato) {
        return candidato != null && !candidato.trim().isEmpty();
    }
}
