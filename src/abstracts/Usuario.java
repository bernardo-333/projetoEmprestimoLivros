package abstracts;

public abstract class Usuario {
    // Id gerado automaticamente
    private static int contador = 1;
    private int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.id = ++contador;
        this.nome = nome;
        this.email = email;
    }

    // Metodo obrigatorio para as subclasses
    public abstract int getLimiteEmprestimos();

    // toString para mostrar informações
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
