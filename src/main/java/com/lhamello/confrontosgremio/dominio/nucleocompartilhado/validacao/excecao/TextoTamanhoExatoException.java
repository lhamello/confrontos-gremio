package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoExatoException extends ErroValidacaoException {

  private static final long serialVersionUID = -7090395242903539606L;
  private static final int UM_CARACTER = 1;

  public TextoTamanhoExatoException(final String nomeCampo, final int tamanhoExato) {
    super(construirMensagem(nomeCampo, tamanhoExato));
  }

  private static String construirMensagem(final String nomeCampo, final int tamanhoExato) {
    String mensagem;

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
