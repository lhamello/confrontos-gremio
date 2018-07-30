package br.com.lham.confrontosgremio.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContinenteUnitTest {

  @DisplayName("Devem existir 6 continentes")
  @Test
  public void deveExistirSeisContinentes() {
    final int numeroContinentesQueDevemExistir = 6;
    assertThat("Devem existir 6 continentes.", Continente.values().length, equalTo(numeroContinentesQueDevemExistir));
  }
  
  @CsvSource({ "AFR, África", "AMN, América do Norte", "AMS, América do Sul", "ASI, Ásia", "EUR, Europa", "OCE, Oceania" })
  @DisplayName("Deve retornar continente correto")
  @ParameterizedTest
  public void deveRetornarInstaciaDeContinente(final String abreviaturaContinente, final String nomeContinente) {
    final Continente continente = Continente.getInstancia(abreviaturaContinente);
    assertThat("Deve retornar a abreviatura do continente correta.", continente.getAbreviatura(), equalTo(abreviaturaContinente));
    assertThat("Deve retornar o nome do continente correto.", continente.getNome(), equalTo(nomeContinente));
  }

  @DisplayName("Deve lançar exceção para abreviatura de continente inválida")
  @ParameterizedTest
  @ValueSource(strings = { "África", "América do Norte", "América do Sul", "Ásia", "Europa", "Oceania" })
  public void deveLancarExcecaoParaAbreviaturaDeContinenteInvalida(final String abreviaturaInvalida) {
    IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getInstancia(abreviaturaInvalida); });
    assertThat("Deve validar a mensagem da exceção.", excecao.getMessage(), equalTo(String.format("Abreviatura informada (%s) é inválida. Valores válidos: AFR, AMN, AMS, ASI, EUR, OCE.", abreviaturaInvalida)));
  }
  
  @Test
  public void deveLancarExcecaoParaAbreviaturaNula() {
    final String abreviaturaNula = null;
    IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getInstancia(abreviaturaNula); });
    assertThat("Deve validar a mensagem da exceção.", excecao.getMessage(), equalTo(String.format("Abreviatura informada (%s) é inválida. Valores válidos: AFR, AMN, AMS, ASI, EUR, OCE.", abreviaturaNula)));
  }
}
