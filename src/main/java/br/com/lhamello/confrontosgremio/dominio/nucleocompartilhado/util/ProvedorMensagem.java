package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class ProvedorMensagem {

  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

  private ProvedorMensagem() {
    throw new AssertionError(getMessagem("erro.instanciacao.classeUtilitaria"));
  }

  public static String getMessagem(final String chave) {
    return RESOURCE_BUNDLE.getString(chave);
  }

  public static String getMensagem(final String chave, final Object... parametros) {
    final String mensagem = getMessagem(chave);
    return MessageFormat.format(mensagem, parametros);
  }
}