package classes;

import abstracts.Usuario;

public class Aluno extends Usuario {
    private int LimiteEmprestimos = 2;

    public Aluno(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return LimiteEmprestimos;
    }
}
