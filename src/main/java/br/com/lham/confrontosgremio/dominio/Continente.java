package br.com.lham.confrontosgremio.dominio;

public enum Continente {

  AFRICA          ("AFR", "África"), 
  AMERICA_DO_NORTE("AMN", "América do Norte"), 
  AMERICA_DO_SUL  ("AMS", "América do Sul"), 
  ASIA            ("ASI", "Ásia"), 
  EUROPA          ("EUR", "Europa"), 
  OCEANIA         ("OCE", "Oceania");

  private final String abreviatura;
  private final String nome;

  private Continente(final String abreviatura, final String nome) {
    this.abreviatura = abreviatura;
    this.nome = nome;
  }

  public String getAbreviatura() {
    return abreviatura;
  }

  public String getNome() {
    return nome;
  }

  public static Continente getInstancia(final String abreviatura) {
    for (Continente continente : Continente.values()) {
      final String abreviaturaContinente = continente.getAbreviatura();

      if (abreviaturaContinente.equalsIgnoreCase(abreviatura)) {
        return continente;
      }
    }

    throw new IllegalArgumentException(String.format("Abreviatura informada (%s) é inválida. Valores válidos: AFR, AMN, AMS, ASI, EUR, OCE.", abreviatura));
  }
}
