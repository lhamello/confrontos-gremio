package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import java.util.List;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public class DominioException extends Exception {

  private static final long serialVersionUID = -1773503057459026038L;
  private List<ErroValidacaoException> errosValidacao;

  public DominioException(final List<ErroValidacaoException> errosValidacao) {
    super("Ocorreu 1 ou mais erros ao validar o domínio."); // TODO: colocar mensagem no arquivos messages.properties
    this.errosValidacao = errosValidacao;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}
