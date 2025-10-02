package classes.usuarios;

import abstracts.Usuario;

// Herança
public class Aluno extends Usuario {
    // Encapsulamento
    private int LimiteEmprestimos = 2;

    public Aluno(String nome, String email) {
        super(nome, email);
    }

    // Polimorfismo (metodo sobrescrito)
    // Metodo abstrato assinado
    @Override
    public int getLimiteEmprestimos() {
        return LimiteEmprestimos;
    }

}
