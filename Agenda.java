import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public boolean removerContato(int id) {
        Contato contato = buscarContatoPorID(id);
        if (contato != null) {
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Contato buscarContato(String termo) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(termo) ||
                contato.getTelefone().equalsIgnoreCase(termo) ||
                contato.getEmail().equalsIgnoreCase(termo)) {
                return contato;
            }
        }
        return null;
    }

    public List<Contato> buscarContatosPorNome(String nome) {
        List<Contato> contatosEncontrados = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatosEncontrados.add(contato);
            }
        }
        return contatosEncontrados;
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    private Contato buscarContatoPorID(int id) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }
}
