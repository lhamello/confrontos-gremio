package br.com.lham.confrontosgremio.dominio;

import br.com.validadorfluente.novo3.Validador;

public final class Pais {

  private static final int TAMANHO_EXATO_ATRIBUTO_ABREVIATURA = 3;
  private static final int TAMANHO_MAXIMO_ATRIBUTO_NOME = 60;
  
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
//    Validador.doDominio(this.getClass())
//             .paraCampo(abreviatura, "Abreviatura").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoIgualA(3)
//             .paraCampo(nome, "Nome").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoMenorOuIgualQue(60)
//             .paraCampo(continente, "Continente").queNaoDeveSerNulo()
//             .validar();
    Validador.paraClasseDominio(this.getClass())
             .queContemAtributo(abreviatura, "Abreviatura").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoIgualA(TAMANHO_EXATO_ATRIBUTO_ABREVIATURA).sempre()
             .queContemAtributo(nome, "Nome").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoMenorOuIgualQue(TAMANHO_MAXIMO_ATRIBUTO_NOME).sempre()
             .queContemAtributo(continente, "Continente").queNaoDeveSerNulo().sempre()
             .validarConstrucao();
  }
}
