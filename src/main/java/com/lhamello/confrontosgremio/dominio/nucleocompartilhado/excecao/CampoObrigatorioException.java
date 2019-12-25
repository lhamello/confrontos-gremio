package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class CampoObrigatorioException extends RuntimeException {

  private static final long serialVersionUID = -7203793613868622224L;

  public CampoObrigatorioException(final String nomeCampo) {
    super(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.campoobrigatorio", nomeCampo));
  }
}
