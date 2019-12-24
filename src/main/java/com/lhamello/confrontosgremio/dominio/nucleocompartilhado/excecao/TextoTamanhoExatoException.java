package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

@SuppressWarnings("serial")
public class TextoTamanhoExatoException extends RuntimeException {

  public TextoTamanhoExatoException(final String nomeCampo, final int tamanhoExato) {
    super(construirMensagem(nomeCampo, tamanhoExato));
  }

  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    if (tamanhoExato > 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.validacao.texto.tamanhoexato.plural", nomeCampo, tamanhoExato);
    } else if (tamanhoExato == 1) {
      return Mensagem.getMensagem("dominio.nucleocompartilhado.validacao.texto.tamanhoexato.singular", nomeCampo, tamanhoExato);
    } else {
      throw new IllegalArgumentException("Texto deve ter tamanho maior que 0.");
    }
  }
}
