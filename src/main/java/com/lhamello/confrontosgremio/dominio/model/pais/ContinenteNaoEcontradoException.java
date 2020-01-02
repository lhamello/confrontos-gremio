package com.lhamello.confrontosgremio.dominio.model.pais;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public class ContinenteNaoEcontradoException extends ErroValidacaoException {

  private static final long serialVersionUID = 6648140321852836198L;

  public ContinenteNaoEcontradoException() {
    super("Continente inválido."); // TODO: mudar
  }
}
