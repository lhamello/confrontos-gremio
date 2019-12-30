package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoExatoException extends RuntimeException {

  private static final long serialVersionUID = -1467720255282608768L;
  private static final int UM_CARACTER = 1;

  public TextoTamanhoExatoException(final String nomeCampo, final int tamanhoExato) {
    super(construirMensagem(nomeCampo, tamanhoExato));
  }

  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    final String mensagem;

    if (tamanhoExato > UM_CARACTER) {
      mensagem = Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.plural", nomeCampo, tamanhoExato);
    } else if (tamanhoExato == UM_CARACTER) {
      mensagem = Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.singular", nomeCampo);
    } else {
      throw new IllegalArgumentException(Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.construcao"));
    }

    return mensagem;
  }
}
