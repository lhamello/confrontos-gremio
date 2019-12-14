package br.com.lham.confrontosgremio.dominio;

public final class Pais {

  private static final short TAMANHO_EXATO_ATRIBUTO_ABREVIATURA = 3;
  private static final short TAMANHO_MAXIMO_ATRIBUTO_NOME = 60;
  
  private final String abreviatura;
  private final String nome;
  private final Continente continente;

  public Pais(final String abreviatura, final String nome, final Continente continente) {
    this.abreviatura = abreviatura;
    this.nome = nome;
    this.continente = continente;
//    this.validarConstrucao();
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

//  private void validarConstrucao() {
//    ValidadorFluente.paraClasseDeDominio(this.getClass())
//                    .queContemAtributo(abreviatura, "Abreviatura").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoIgualA(TAMANHO_EXATO_ATRIBUTO_ABREVIATURA).validar()
//                    .queContemAtributo(nome, "Nome").queNaoDeveSerNulo().queNaoDeveSerVazio().queDeveTerTamanhoMenorOuIgualQue(TAMANHO_MAXIMO_ATRIBUTO_NOME).validar()
//                    .queContemAtributo(continente, "Continente").queNaoDeveSerNulo().validar()
//                    .contruirDominio();
//  }
}
