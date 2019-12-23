package com.lham.confrontosgremio.dominio.model.pais;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lhamello.confrontosgremio.dominio.model.pais.Continente;

public class ContinenteUnitTest {

  private final int NUMERO_CONSTANTES_ENUM = 6;

  @Test
  public void deveExistir6Continentes() {
    assertEquals(NUMERO_CONSTANTES_ENUM, Continente.values().length);
  }

  @ParameterizedTest
  @CsvSource(value = { "AFRICA, AFR", "AMERICA_DO_NORTE, AMN", "AMERICA_DO_SUL, AMS", "ASIA, ASI", "EUROPA, EUR", "OCEANIA, OCE" })
  public void deveRetornarAbreviaturaCorreta(final Continente continenteAtual, final String abreviaturaEsperada) {
    assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura());
  }

  @ParameterizedTest
  @CsvSource(value = { "AFRICA, África", "AMERICA_DO_NORTE, América do Norte", "AMERICA_DO_SUL, América do Sul", "ASIA, Ásia", "EUROPA, Europa", "OCEANIA, Oceania" })
  public void deveRetornarNomeCorreto(final Continente continenteAtual, final String nomeEsperado) {
    assertEquals(nomeEsperado, continenteAtual.getNome());
  }

  @ParameterizedTest
  @CsvSource(value = { "AFRICA, AFR", "AMERICA_DO_NORTE, AMN", "AMERICA_DO_SUL, AMS", "ASIA, ASI", "EUROPA, EUR", "OCEANIA, OCE" })
  public void deveRetornarConstanteCorreta(final Continente continenteEsperado, final String siglaAtual) {
    assertEquals(continenteEsperado, Continente.getInstancia(siglaAtual).get());
  }

  @ParameterizedTest
  @CsvSource(value = { "AFRICA, África (AFR)", "AMERICA_DO_NORTE, América do Norte (AMN)", "AMERICA_DO_SUL, América do Sul (AMS)", "ASIA, Ásia (ASI)", "EUROPA, Europa (EUR)",
      "OCEANIA, Oceania (OCE)" })
  public void deveRetornarDescricaoCorreta(final Continente continenteAtual, final String descricaoEsperada) {
    assertEquals(descricaoEsperada, continenteAtual.toString());
  }
  
  @ParameterizedTest
  @CsvSource(value = { "AFRICA, 0", "AMERICA_DO_NORTE, 1", "AMERICA_DO_SUL, 2", "ASIA, 3", "EUROPA, 4", "OCEANIA, 5" })
  public void deveRetornarNumeracaoCorreta(final Continente continenteAtual, final int numeroEsperado) {
    assertEquals(numeroEsperado, continenteAtual.ordinal());
  }


  @ParameterizedTest
  @ValueSource(strings = { "África", "América do Norte", "América do Sul", "Europa", "Oceania", " " })
  @NullAndEmptySource
  public void naoDeveRetornarContinente(final String abreviatura) {
    assertEquals(Optional.empty(), Continente.getInstancia(abreviatura));
  }
}
