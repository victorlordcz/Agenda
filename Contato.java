public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String aniversario;

    public Contato(int id, String nome, String telefone, String email, String aniversario) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.aniversario = aniversario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getAniversario() {
        return aniversario;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email + "\nAniversário: " + aniversario;
    }
}