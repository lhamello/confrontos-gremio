package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public abstract class Validacao<T> {

  private List<ErroValidacaoException> errosValidacao;
  protected T atributo;
  protected String nomeAtributo;

  public Validacao() {
    this.errosValidacao = new LinkedList<>();
  }

  protected Validacao<T> executarValidacao(final Predicate<T> predicado, final T objeto, final ErroValidacaoException excecaoCasoNaoSejaValido) {
    if (!predicado.test(objeto)) {
      this.errosValidacao.add(excecaoCasoNaoSejaValido);
    }

    return this;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}
