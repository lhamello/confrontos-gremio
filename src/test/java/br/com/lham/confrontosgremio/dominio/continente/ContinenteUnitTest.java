package br.com.lham.confrontosgremio.dominio.continente;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lham.confrontosgremio.dominio.continente.Continente;

public class ContinenteUnitTest {

  private String formatoDescricao = "%s (%s)";

  @Test
  public void deveExistir6Continentes() {
    assertEquals(6, Continente.values().length);
  }

  @Test
  public void deveRetornarAfrica() {
    final String abreviaturaEsperada = "AFR";
    final String nomeEsperado = "África";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.AFRICA);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.AFRICA;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(0, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("AFRICA")));
  }

  @Test
  public void deveRetornarAmericaDoNorte() {
    final String abreviaturaEsperada = "AMN";
    final String nomeEsperado = "América do Norte";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.AMERICA_DO_NORTE);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.AMERICA_DO_NORTE;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(1, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("AMERICA_DO_NORTE")));
  }

  @Test
  public void deveRetornarAmericaDoSul() {
    final String abreviaturaEsperada = "AMS";
    final String nomeEsperado = "América do Sul";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.AMERICA_DO_SUL);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.AMERICA_DO_SUL;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(2, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("AMERICA_DO_SUL")));
  }

  @Test
  public void deveRetornarAsia() {
    final String abreviaturaEsperada = "ASI";
    final String nomeEsperado = "Ásia";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.ASIA);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.ASIA;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(3, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("ASIA")));
  }

  @Test
  public void deveRetornarEuropa() {
    final String abreviaturaEsperada = "EUR";
    final String nomeEsperado = "Europa";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.EUROPA);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.EUROPA;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(4, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("EUROPA")));
  }

  @Test
  public void deveRetornarOceania() {
    final String abreviaturaEsperada = "OCE";
    final String nomeEsperado = "Oceania";
    final Optional<Continente> continenteEsperado = Optional.of(Continente.OCEANIA);
    final String descricaoEsperada = String.format(formatoDescricao, nomeEsperado, abreviaturaEsperada);
    final Continente continenteAtual = Continente.OCEANIA;

    assertAll(() -> assertEquals(abreviaturaEsperada, continenteAtual.getAbreviatura()),
        () -> assertEquals(nomeEsperado, continenteAtual.getNome()),
        () -> assertEquals(continenteEsperado, Continente.getInstancia(abreviaturaEsperada)),
        () -> assertEquals(descricaoEsperada, continenteAtual.toString()),
        () -> assertEquals(5, continenteAtual.ordinal()),
        () -> assertEquals(continenteEsperado.get(), Continente.valueOf("OCEANIA")));
  }

  @ParameterizedTest
  @ValueSource(strings = { "África", "América do Norte", "América do Sul", "Europa", "Oceania", " " })
  @NullAndEmptySource
  public void naoDeveRetornarContinente(final String abreviatura) {
    assertEquals(Optional.empty(), Continente.getInstancia(abreviatura));
  }
}
