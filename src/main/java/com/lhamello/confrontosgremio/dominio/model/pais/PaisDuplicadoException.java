package com.lhamello.confrontosgremio.dominio.model.pais;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public class PaisDuplicadoException extends ErroValidacaoException {

  private static final long serialVersionUID = 212422358237398220L;

  public PaisDuplicadoException() {
    super("País já cadastradao."); // TODO: colocar no messages
  }
}
