package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoExatoException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoMaximoException;

public final class Validacao {

  private List<Exception> errosValidacao;

  public Validacao() {
    this.errosValidacao = new LinkedList<>();
  }
  
  public List<Exception> getErrosValidacao() {
    return errosValidacao;
  }

  public void campoObrigatorio(final Object campo, final String nomeCampo) {
    if (Objects.isNull(campo)) {
      errosValidacao.add(new CampoObrigatorioException(nomeCampo));
    }

    if (campo instanceof String && ((String) campo).isBlank()) {
      errosValidacao.add(new CampoObrigatorioException(nomeCampo));
    }
  }

  public void campoComTamanhoExato(final int tamanhoExatoCampo, final String campo, final String nomeCampo) {
    if (Objects.isNull(campo) || campo.length() != tamanhoExatoCampo) {
      errosValidacao.add(new TextoTamanhoExatoException(nomeCampo, tamanhoExatoCampo));
    }
  }

  public void campoComTamanhoMaximo(final int tamanhoMaximoCampo, final String campo, final String nomeCampo) {
    if (Objects.isNull(campo) || campo.length() > tamanhoMaximoCampo) {
      errosValidacao.add(new TextoTamanhoMaximoException(nomeCampo, tamanhoMaximoCampo));
    }
  }

//  private Validacao() {
//    throw new AssertionError(Mensagem.getMensagem("global.erro.instanciar.classeutilitaria"));
//  }

//  public static void campoObrigatorio(final Object campo, final String nomeCampo) {
//    if (Objects.isNull(campo)) {
//      throw new CampoObrigatorioException(nomeCampo);
//    }
//
//    if (campo instanceof String && ((String) campo).isBlank()) {
//      throw new CampoObrigatorioException(nomeCampo);
//    }
//  }
//
//  public static void campoComTamanhoExato(final int tamanhoExatoCampo, final String campo, final String nomeCampo) {
//    if (Objects.isNull(campo) || campo.length() != tamanhoExatoCampo) {
//      throw new TextoTamanhoExatoException(nomeCampo, tamanhoExatoCampo);
//    }
//  }
//
//  public static void campoComTamanhoMaximo(final int tamanhoMaximoCampo, final String campo, final String nomeCampo) {
//    if (Objects.isNull(campo) || campo.length() > tamanhoMaximoCampo) {
//      throw new TextoTamanhoMaximoException(nomeCampo, tamanhoMaximoCampo);
//    }
//  }
}
