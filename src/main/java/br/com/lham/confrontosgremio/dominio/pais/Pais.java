package br.com.lham.confrontosgremio.dominio.pais;

import br.com.lham.confrontosgremio.dominio.continente.Continente;
import br.com.lham.confrontosgremio.nucleo.excecao.CampoObrigatorioException;

public class Pais {

  private String abreviatura;
  private String nome;
  private Continente continente;

  public Pais(final String abreviatura, final String nome, final Continente continente) throws CampoObrigatorioException {
    if (abreviatura == null || abreviatura.isBlank()) { throw new CampoObrigatorioException("Abreviatura"); }
    if (nome == null || nome.isBlank()) { throw new CampoObrigatorioException("Nome"); }
    if (continente == null) { throw new CampoObrigatorioException("Continente"); }
    this.abreviatura = abreviatura;
    this.nome = nome;
    this.continente = continente;
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
