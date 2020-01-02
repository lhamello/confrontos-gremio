package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao;

import java.util.LinkedList;
import java.util.List;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public class Validador {

  private List<Validacao<?>> validacoes;

  private Validador() {
    this.validacoes = new LinkedList<>();
  }

  public static Validador paraObjetoDominio() {
    return new Validador();
  }

  public Validador comValidacoes(final Validacao<?> validacao) {
    this.validacoes.add(validacao);
    return this;
  }

  public List<ErroValidacaoException> validar() {
    List<ErroValidacaoException> errosValidacao = new LinkedList<>();

    for (Validacao<?> validacao : validacoes) {
      errosValidacao.addAll(validacao.getErrosValidacao());
    }

    return errosValidacao;
  }
}