package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoExatoException extends RuntimeException {

  private static final long serialVersionUID = -1467720255282608768L;

  public TextoTamanhoExatoException(final String nomeCampo, final int tamanhoExato) {
    super(construirMensagem(nomeCampo, tamanhoExato));
  }

  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    if (tamanhoExato > 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.plural", nomeCampo, tamanhoExato);
    } else if (tamanhoExato == 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.singular", nomeCampo);
    } else {
      throw new IllegalArgumentException(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.construcao"));
    }
  }
}
