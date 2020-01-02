package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class CampoObrigatorioException extends ErroValidacaoException {

  private static final long serialVersionUID = 3138437383776817544L;

  public CampoObrigatorioException(final String nomeCampo) {
    super(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.campoobrigatorio", nomeCampo));
  }
}
