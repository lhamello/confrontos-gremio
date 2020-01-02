package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

public class TextoTamanhoMaximoException extends ErroValidacaoException {

  private static final long serialVersionUID = 2585985271761982604L;
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
