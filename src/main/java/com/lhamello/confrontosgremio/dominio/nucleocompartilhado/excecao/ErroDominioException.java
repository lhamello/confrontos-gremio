package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import java.util.List;

public class ErroDominioException extends RuntimeException {

  private static final long serialVersionUID = 7351623678582382615L;
  private List<Exception> errosValidacao;

  public ErroDominioException(final List<Exception> errosValidacao) {
    super("Ocorreu 1 ou mais erros ao validar o domínio."); // TODO: colocar mensagem no arquivos messages.properties
    this.errosValidacao = errosValidacao;
  }

  public List<Exception> getErrosValidacao() {
    return errosValidacao;
  }
}
