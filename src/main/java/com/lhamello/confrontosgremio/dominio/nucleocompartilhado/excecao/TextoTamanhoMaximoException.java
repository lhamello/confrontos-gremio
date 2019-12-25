package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoMaximoException extends RuntimeException {

  private static final long serialVersionUID = -654823636615792950L;

  public TextoTamanhoMaximoException(final String nomeCampo, final int tamanhoMaximo) {
    super(construirMensagem(nomeCampo, tamanhoMaximo));
  }
  
  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    if (tamanhoExato > 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.plural", nomeCampo, tamanhoExato);
    } else if (tamanhoExato == 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.singular", nomeCampo);
    } else {
      throw new IllegalArgumentException(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhomaximo.construcao"));
    }
  }
}
