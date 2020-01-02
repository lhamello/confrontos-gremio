package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao;

public class ErroValidacaoException extends RuntimeException {

  private static final long serialVersionUID = 5487281651461927319L;

  public ErroValidacaoException(final String mensagemErro) {
    super(mensagemErro);
  }
}
