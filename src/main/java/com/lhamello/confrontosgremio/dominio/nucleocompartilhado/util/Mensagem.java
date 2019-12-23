package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class Mensagem {

  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

  private Mensagem() {
    throw new AssertionError(getMensagem("global.erro.instanciar.classeutilitaria"));
  }

  public static String getMensagem(final String chave) {
    return RESOURCE_BUNDLE.getString(chave);
  }

  public static String getMensagem(final String chave, Object... parametros) {
    final String mensagem = getMensagem(chave);
    return MessageFormat.format(mensagem, parametros);
  }
}
