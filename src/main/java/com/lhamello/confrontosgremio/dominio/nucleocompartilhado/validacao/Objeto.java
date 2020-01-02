package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao;

import java.util.function.Predicate;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.CampoObrigatorioException;

public class Objeto extends Validacao<Object> {

  public Objeto(final Object atributo, final String nomeAtributo) {
    super.atributo = atributo;
    super.nomeAtributo = nomeAtributo;
  }

  public static Objeto paraAtributo(final Object atributo, final String nomeAtributo) {
    return new Objeto(atributo, nomeAtributo);
  }

  public Objeto queNaoDeveSerNulo() {
    Predicate<Object> objetoNaoDeveSerNulo = o -> o != null;
    return (Objeto) super.executarValidacao(objetoNaoDeveSerNulo, atributo, new CampoObrigatorioException(nomeAtributo));
  }
}
