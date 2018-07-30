package br.com.lham.confrontosgremio.dominio;

import java.util.LinkedList;
import java.util.List;

import br.com.lham.confrontosgremio.infraestrutura.validacao.ErroValidacaoException;
import br.com.lham.confrontosgremio.infraestrutura.validacao.ValidadorObject;
import br.com.lham.confrontosgremio.infraestrutura.validacao.ValidadorString;

public final class Pais {

  private final String abreviatura;
  private final String nome;
  private final Continente continente;

  public Pais(final String abreviatura, final String nome, final Continente continente) {
    this.abreviatura = abreviatura;
    this.nome = nome;
    this.continente = continente;
    this.validarConstrucao();
  }

  public String getAbreviatura() {
    return abreviatura;
  }

  public String getNome() {
    return nome;
  }

  public Continente getContinente() {
    return continente;
  }

  private void validarConstrucao() {
    List<ErroValidacaoException> errosValidacaoDominio = new LinkedList<>();

    errosValidacaoDominio.addAll(ValidadorString.paraCampo(abreviatura, "Abreviatura").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoIgualA(3).validar());
    errosValidacaoDominio.addAll(ValidadorString.paraCampo(nome, "Nome").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoMenorOuIgualQue(60).validar());
    errosValidacaoDominio.addAll(ValidadorObject.paraCampo(continente, "Continente").queNaoDeveSerNulo().validar());

    if (!errosValidacaoDominio.isEmpty()) {
      throw new PaisInvalidoException(errosValidacaoDominio);
    }
  }
}
