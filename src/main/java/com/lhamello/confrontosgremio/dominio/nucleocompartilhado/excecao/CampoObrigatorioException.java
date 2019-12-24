package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

@SuppressWarnings("serial")
public class CampoObrigatorioException extends RuntimeException {

  public CampoObrigatorioException(final String nomeCampo) {
    super(Mensagem.getMensagem("dominio.nucleocompartilhado.validacao.campoobrigatorio", nomeCampo));
  }
}
