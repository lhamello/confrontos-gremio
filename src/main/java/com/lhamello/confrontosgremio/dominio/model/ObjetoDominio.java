package com.lhamello.confrontosgremio.dominio.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.ErroValidacaoException;

public abstract class ObjetoDominio implements Serializable {

  private static final long serialVersionUID = -2633917057542287450L;
  protected List<ErroValidacaoException> errosValidacao;

  public ObjetoDominio() {
    this.errosValidacao = new LinkedList<>();
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}
