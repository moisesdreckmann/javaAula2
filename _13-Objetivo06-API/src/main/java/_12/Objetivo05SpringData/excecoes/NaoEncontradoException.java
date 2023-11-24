package _12.Objetivo05SpringData.excecoes;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
