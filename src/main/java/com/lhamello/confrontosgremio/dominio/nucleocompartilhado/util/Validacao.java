package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import java.util.Objects;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.TextoTamanhoExatoException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.TextoTamanhoMaximoException;

public final class Validacao {

  private Validacao() {
    throw new AssertionError(Mensagem.getMensagem("global.erro.instanciar.classeutilitaria"));
  }

  public static void campoObrigatorio(final Object campo, final String nomeCampo) {
    if (Objects.isNull(campo)) {
      throw new CampoObrigatorioException(nomeCampo);
    }

    if (campo instanceof String && ((String) campo).isBlank()) {
      throw new CampoObrigatorioException(nomeCampo);
    }
  }

  public static void campoComTamanhoExato(final int tamanhoExatoCampo, final String campo, final String nomeCampo) {
    if (Objects.isNull(campo) || campo.length() != tamanhoExatoCampo) {
      throw new TextoTamanhoExatoException(nomeCampo, tamanhoExatoCampo);
    }
  }

  public static void campoComTamanhoMaximo(final int tamanhoMaximoCampo, final String campo, final String nomeCampo) {
    if (Objects.isNull(campo) || campo.length() > tamanhoMaximoCampo) {
      throw new TextoTamanhoMaximoException(nomeCampo, tamanhoMaximoCampo);
    }
  }
}
