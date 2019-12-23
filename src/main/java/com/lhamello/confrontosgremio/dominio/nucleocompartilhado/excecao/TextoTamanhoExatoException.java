package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Mensagem;

@SuppressWarnings("serial")
public class TextoTamanhoExatoException extends RuntimeException {

  public TextoTamanhoExatoException(final String nomeCampo, final int tamanhoExato) {
    super(Mensagem.getMensagem("dominio.nucleocompartilhado.validacao.campo.texto.invalido.tamanhoexato", nomeCampo, tamanhoExato));
  }
}
