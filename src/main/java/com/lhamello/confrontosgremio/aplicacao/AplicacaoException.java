package com.lhamello.confrontosgremio.aplicacao;

public class AplicacaoException extends Exception {

  private static final long serialVersionUID = 8018299730084133425L;

  public AplicacaoException(final Throwable excecaoOriginal) {
    super(excecaoOriginal);
  }
}
