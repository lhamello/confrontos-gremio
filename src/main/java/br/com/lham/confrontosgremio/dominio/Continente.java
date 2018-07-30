package br.com.lham.confrontosgremio.dominio;

public enum Continente {

  AFRICA          ("AFR", "�frica"), 
  AMERICA_DO_NORTE("AMN", "Am�rica do Norte"), 
  AMERICA_DO_SUL  ("AMS", "Am�rica do Sul"), 
  ASIA            ("ASI", "�sia"), 
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

    throw new IllegalArgumentException(String.format("Abreviatura informada (%s) � inv�lida.", abreviatura));
  }
  
  public static Continente getContinentePorNome(final String nome) {
    for (Continente continente : Continente.values()) {
      final String nomeContinente = continente.getNome();

      if (nomeContinente.equalsIgnoreCase(nome)) {
        return continente;
      }
    }

    throw new IllegalArgumentException(String.format("Nome informado (%s) � inv�lido.", nome));
  }
  
  @Override
  public String toString() {
    final StringBuilder descricao = new StringBuilder();
    descricao.append(abreviatura).append(" - ").append(nome);
    return descricao.toString();
  }
}
