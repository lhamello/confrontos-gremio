package br.com.lhamello.confrontosgremio.model;

import java.util.Arrays;
import java.util.Optional;

public enum Continente {

  AFRICA          ("AFR", "África"),
  AMERICA_DO_NORTE("AMN", "América do Norte"),
  AMERICA_DO_SUL  ("AMS", "América do Sul"),
  ASIA            ("ASI", "Ásia"),
  EUROPA          ("EUR", "Europa"),
  OCEANIA         ("OCE", "Oceania");

  private String sigla;
  private String nome;

  Continente(final String sigla, final String nome) {
    this.sigla = sigla;
    this.nome = nome;
  }

  public String getSigla() {
    return sigla;
  }

  public String getNome() {
    return nome;
  }

  public static Optional<Continente> of(final String sigla) {
    return Arrays.asList(values())
        .stream()
        .filter(c -> c.getSigla().equals(sigla))
        .findFirst();
  }

  @Override
  public String toString() {
    return String.format("% (%)", nome, sigla);
  }
}
