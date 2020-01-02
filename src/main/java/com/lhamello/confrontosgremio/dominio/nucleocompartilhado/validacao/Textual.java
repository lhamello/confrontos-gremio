package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao;

import java.util.function.Predicate;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoExatoException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoMaximoException;

public class Textual extends Validacao<String> {

  public Textual(final String atributo, final String nomeAtributo) {
    super.atributo = atributo;
    super.nomeAtributo = nomeAtributo;
  }

  public static Textual paraAtributo(final String atributo, final String nomeAtributo) {
    return new Textual(atributo, nomeAtributo);
  }

  public Textual queDeveEstarPreenchido() {
    Predicate<String> textoDeveEstarPreenchido = t -> t != null && !t.isBlank();
    return (Textual) super.executarValidacao(textoDeveEstarPreenchido, atributo, new CampoObrigatorioException(nomeAtributo));
  }

  public Textual queDeveTerTamanhoExato(final int tamanhoExato) {
    Predicate<String> textoDeveTerTamanhoExato = t -> t != null && t.length() == tamanhoExato;
    return (Textual) super.executarValidacao(textoDeveTerTamanhoExato, atributo, new TextoTamanhoExatoException(nomeAtributo, tamanhoExato));
  }

  public Textual queDeveTerTamanhoMaximo(final int tamanhoMaximo) {
    Predicate<String> textoDeveTerTamanhoMaximo = t -> t != null && t.length() <= tamanhoMaximo;
    return (Textual) super.executarValidacao(textoDeveTerTamanhoMaximo, atributo, new TextoTamanhoMaximoException(nomeAtributo, tamanhoMaximo));
  }
}
