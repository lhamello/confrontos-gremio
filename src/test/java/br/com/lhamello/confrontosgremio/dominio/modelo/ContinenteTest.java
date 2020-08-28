package br.com.lhamello.confrontosgremio.dominio.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lhamello.confrontosgremio.old.dominio.modelo.pais.Continente;

class ContinenteTest {

  @Test
  public void deveExistirSeisContinentes() {
    assertEquals(6, Continente.values().length);
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource(value = { 
      "AFR, AFRICA", 
      "AMN, AMERICA_DO_NORTE", 
      "AMS, AMERICA_DO_SUL", 
      "ASI, ASIA", 
      "EUR, EUROPA", 
      "OCE, OCEANIA" })
  public void deveRetornarAbreviaturaEsperada(final String abreviaturaEsperada, final Continente continente) {
    assertEquals(abreviaturaEsperada, continente.getAbreviatura());
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource(value = { 
      "África, AFRICA", 
      "América do Norte, AMERICA_DO_NORTE", 
      "América do Sul, AMERICA_DO_SUL", 
      "Ásia, ASIA", 
      "Europa, EUROPA", 
      "Oceania, OCEANIA" })
  public void deveRetornarNomeEsperado(final String nomeEsperado, final Continente continente) {
    assertEquals(nomeEsperado, continente.getNome());
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource(value = { 
      "AFRICA, AFR", 
      "AMERICA_DO_NORTE, amn", 
      "AMERICA_DO_SUL, Ams", 
      "ASIA, AsI", 
      "EUROPA, euR", 
      "OCEANIA, oCe" })
  public void deveRetornarContinenteEsperado(final Continente continenteEsperado, final String abreviatura) {
    assertEquals(continenteEsperado, Continente.of(abreviatura).get());
  }
  
  @ParameterizedTest
  @ValueSource(strings = { "", " ", "Teste" })
  public void naoDeveRetornarContinente(final String abreviatura) {
    assertEquals(Optional.empty(), Continente.of(abreviatura));
  }
  
  @Test
  public void naoDeveRetornarContinenteParaAbreviaturaNula() {
    assertEquals(Optional.empty(), Continente.of(null));
  }
  
  @ParameterizedTest(name = "{0}")
  @CsvSource(value = { 
      "0, AFRICA", 
      "1, AMERICA_DO_NORTE", 
      "2, AMERICA_DO_SUL", 
      "3, ASIA", 
      "4, EUROPA", 
      "5, OCEANIA" })
  public void deveRetornarOrdinalEsperado(final int ordinalEsperado, final Continente continente) {
    assertEquals(ordinalEsperado, continente.ordinal());
  }
  
  @ParameterizedTest(name = "{0}")
  @CsvSource(value = { 
      "África (AFR), AFRICA", 
      "América do Norte (AMN), AMERICA_DO_NORTE", 
      "América do Sul (AMS), AMERICA_DO_SUL", 
      "Ásia (ASI), ASIA", 
      "Europa (EUR), EUROPA", 
      "Oceania (OCE), OCEANIA" })
  public void deveRetornarDescricaoEsperada(final String descricaoEsperada, final Continente continente) {
    assertEquals(descricaoEsperada, continente.toString());
  }
}
