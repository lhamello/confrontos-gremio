package com.lhamello.confrontosgremio.dominio.model.pais;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Validacao;

public final class Pais {

  private static final int TAMANHO_ABREVIATURA = 3;
  private static final int TAMANHO_MAXIMO_NOME = 50;
  private final String abreviatura;
  private final String nome;
  private final Continente continente;

  public Pais(final String abreviatura, final String nome, final Continente continente) {
    this.abreviatura = validarAbreviatura(abreviatura, "Abreviatura", TAMANHO_ABREVIATURA);
    this.nome = validarNome(nome, "Nome", TAMANHO_MAXIMO_NOME);
    this.continente = validarContinente(continente, "Continente");
  }

  private static String validarAbreviatura(final String abreviatura, final String nomeCampo, final int tamanhoExatoCampo) {
    Validacao.campoObrigatorio(abreviatura, nomeCampo);
    Validacao.campoComTamanhoExato(tamanhoExatoCampo, abreviatura, nomeCampo);
    return abreviatura;
  }

  private static String validarNome(final String nome, final String nomeCampo, final int tamanhoMaximoCampo) {
    Validacao.campoObrigatorio(nome, nomeCampo);
    Validacao.campoComTamanhoMaximo(tamanhoMaximoCampo, nome, nomeCampo);
    return nome;
  }

  private static Continente validarContinente(final Continente continente, final String nomeCampo) {
    Validacao.campoObrigatorio(continente, nomeCampo);
    return continente;
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

  @Override
  public String toString() {
    return String.format("%s (%s)", nome, abreviatura);
  }
}
