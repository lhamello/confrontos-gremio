package br.com.lham.confrontosgremio.infraestrutura.validacao;

public class ErroValidacaoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ErroValidacaoException(final String mensagem) {
    super(mensagem);
  }
}
