package br.com.lham.confrontosgremio.dominio.continente;

import java.util.Arrays;
import java.util.Optional;

public enum Continente {

  AFRICA          ("AFR", "África"), 
  AMERICA_DO_NORTE("AMN", "América do Norte"), 
  AMERICA_DO_SUL  ("AMS", "América do Sul"), 
  ASIA            ("ASI", "Ásia"), 
  EUROPA          ("EUR", "Europa"), 
  OCEANIA         ("OCE", "Oceania");

  private String abreviatura;
  private String nome;

  private Continente(final String abreviatura, final String nome) {
    this.abreviatura = abreviatura;
    this.nome = nome;
  }

  public static Optional<Continente> getInstancia(final String abreviatura) {
    Continente continente = Arrays.stream(values())
        .filter(c -> c.getAbreviatura().equals(abreviatura))
        .findFirst()
        .orElse(null);
    return Optional.ofNullable(continente);
  }
  
  public String getAbreviatura() {
    return abreviatura;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", nome, abreviatura);
  }
}
