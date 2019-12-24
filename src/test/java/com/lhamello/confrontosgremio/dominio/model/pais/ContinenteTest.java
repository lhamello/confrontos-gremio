package com.lhamello.confrontosgremio.dominio.model.pais;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContinenteTest {

  @Test
  public void deveExistirSeisContinentes() {
    assertEquals(6, Continente.values().length);
  }

  @ParameterizedTest
  @CsvSource(value = { "AFR, AFRICA", "AMN, AMERICA_DO_NORTE", "AMS, AMERICA_DO_SUL", "ASI, ASIA", "EUR, EUROPA", "OCE, OCEANIA" })
  public void deveRetornarAbreviaturaCorreta(final String abreviaturaEsperada, final Continente continenteAtual) {
    assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura());
  }

  @ParameterizedTest
  @CsvSource(value = { "África, AFRICA", "América do Norte, AMERICA_DO_NORTE", "América do Sul, AMERICA_DO_SUL", "Ásia, ASIA", "Europa, EUROPA", "Oceania, OCEANIA" })
  public void deveRetornarNomeCorreto(final String nomeEsperado, final Continente continenteAtual) {
    assertEquals(nomeEsperado, continenteAtual.getNome());
  }

  @ParameterizedTest
  @CsvSource(value = { "AFRICA, AFR", "AMERICA_DO_NORTE, AMN", "AMERICA_DO_SUL, AMS", "ASIA, ASI", "EUROPA, EUR", "OCEANIA, OCE" })
  public void deveRetornarConstanteCorreta(final Continente continenteEsperado, final String siglaAtual) {
    assertEquals(continenteEsperado, Continente.getInstancia(siglaAtual).get());
  }

  @ParameterizedTest
  @CsvSource(value = { "África (AFR), AFRICA", "América do Norte (AMN), AMERICA_DO_NORTE", "América do Sul (AMS), AMERICA_DO_SUL", "Ásia (ASI), ASIA", "Europa (EUR), EUROPA",
      "Oceania (OCE), OCEANIA" })
  public void deveRetornarDescricaoCorreta(final String descricaoEsperada, final Continente continenteAtual) {
    assertEquals(descricaoEsperada, continenteAtual.toString());
  }

  @ParameterizedTest
  @CsvSource(value = { "0, AFRICA", "1, AMERICA_DO_NORTE", "2, AMERICA_DO_SUL", "3, ASIA", "4, EUROPA", "5, OCEANIA" })
  public void deveRetornarNumeracaoCorreta(final int numeroEsperado, final Continente continenteAtual) {
    assertEquals(numeroEsperado, continenteAtual.ordinal());
  }

  @ParameterizedTest
  @ValueSource(strings = { "África", "América do Norte", "América do Sul", "Europa", "Oceania", " " })
  @NullAndEmptySource
  public void naoDeveRetornarContinente(final String abreviatura) {
    assertEquals(Optional.empty(), Continente.getInstancia(abreviatura));
  }
}
