package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoMaximoException extends RuntimeException {

  private static final long serialVersionUID = -654823636615792950L;
  private static final int UM_CARACTER = 1;

  public TextoTamanhoMaximoException(final String nomeCampo, final int tamanhoMaximo) {
    super(construirMensagem(nomeCampo, tamanhoMaximo));
  }

  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    String mensagem;

    if (tamanhoExato > UM_CARACTER) {
      mensagem = Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.plural", nomeCampo, tamanhoExato);
    } else if (tamanhoExato == UM_CARACTER) {
      mensagem = Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.singular", nomeCampo);
    } else {
      throw new IllegalArgumentException(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.construcao"));
    }

    return mensagem;
  }
}
