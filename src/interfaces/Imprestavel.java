package interfaces;

import abstracts.Usuario;

// Interface obrigando a um produto emprestar e devolver
public interface Imprestavel {
    String emprestar(Usuario u);
    String devolver();
}
