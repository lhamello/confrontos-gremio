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

  public static Continente getContinentePorAbreviatura(final String abreviatura) {
    for (Continente continente : Continente.values()) {
      final String abreviaturaContinente = continente.getAbreviatura();

      if (abreviaturaContinente.equalsIgnoreCase(abreviatura)) {
        return continente;
      }
    }

    throw new IllegalArgumentException(String.format("Abreviatura informada (%s) é inválida.", abreviatura));
  }
  
  public static Continente getContinentePorNome(final String nome) {
    for (Continente continente : Continente.values()) {
      final String nomeContinente = continente.getNome();

      if (nomeContinente.equalsIgnoreCase(nome)) {
        return continente;
      }
    }

    throw new IllegalArgumentException(String.format("Nome informado (%s) é inválido.", nome));
  }
  
  @Override
  public String toString() {
    final StringBuilder descricao = new StringBuilder();
    descricao.append(abreviatura).append(" - ").append(nome);
    return descricao.toString();
  }
}
