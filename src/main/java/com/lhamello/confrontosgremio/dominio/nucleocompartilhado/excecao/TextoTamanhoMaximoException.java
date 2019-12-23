package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

@SuppressWarnings("serial")
public class TextoTamanhoMaximoException extends RuntimeException {

  public TextoTamanhoMaximoException(final String nomeCampo, final int tamanhoMaximo) {
    super(Mensagem.getMensagem("dominio.nucleocompartilhado.validacao.campo.texto.invalido.tamanhomaximo", nomeCampo, tamanhoMaximo));
  }
}
