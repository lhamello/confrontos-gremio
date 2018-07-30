package br.com.lham.confrontosgremio.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContinenteUnitTest {

  @Test
  public void deveExistir6Continentes() {
    final int numeroContinentesQueDevemExistir = 6;
    assertThat("Deve existir 6 continentes.", Continente.values().length, equalTo(numeroContinentesQueDevemExistir));
  }
  
  @CsvSource({ "AFR, �frica", "AMN, Am�rica do Norte", "AMS, Am�rica do Sul", "ASI, �sia", "EUR, Europa", "OCE, Oceania" })
  @ParameterizedTest
  public void deveRetornarInstaciaCorretaPesquisandoPorAbreviatura(final String abreviaturaContinente, final String nomeContinente) {
    final Continente continente = Continente.getContinentePorAbreviatura(abreviaturaContinente);
    assertThat("Deve retornar a abreviatura do continente correta ap�s pesquis�-lo por sua abreviatura.", continente.getAbreviatura(), equalTo(abreviaturaContinente));
    assertThat("Deve retornar o nome do continente correto ap�s pesquis�-lo por sua abreviatura.",        continente.getNome(),        equalTo(nomeContinente));
    assertThat("Deve validar toString()",                                                                 continente.toString(),       equalTo(abreviaturaContinente + " - " + nomeContinente));
  }
  
  @CsvSource({ "AFR, �frica", "AMN, Am�rica do Norte", "AMS, Am�rica do Sul", "ASI, �sia", "EUR, Europa", "OCE, Oceania" })
  @ParameterizedTest
  public void deveRetornarInstaciaCorretaPesquisandoPorNome(final String abreviaturaContinente, final String nomeContinente) {
    final Continente continente = Continente.getContinentePorNome(nomeContinente);
    assertThat("Deve retornar a abreviatura do continente correta ap�s pequis�-lo por seu nome.",  continente.getAbreviatura(), equalTo(abreviaturaContinente));
    assertThat("Deve retornar o nome do continente correto ap�s pesquis�-lo por seu nome.",        continente.getNome(),        equalTo(nomeContinente));
  }
  
  @ParameterizedTest
  @ValueSource(strings = { "�frica", "Am�rica do Norte", "Am�rica do Sul", "�sia", "Europa", "Oceania" })
  public void deveLancarExcecaoParaAbreviaturaDeContinenteInvalida(final String abreviaturaInvalida) {
    final IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getContinentePorAbreviatura(abreviaturaInvalida); });
    assertThat("Deve lan�ar exce��o de abreviatura inv�lida.", excecao.getMessage(), equalTo(String.format("Abreviatura informada (%s) � inv�lida.", abreviaturaInvalida)));
  }
  
  @ParameterizedTest
  @ValueSource(strings = { "AFR", "AMN", "AMS", "ASI", "EUR", "OCE" })
  public void deveLancarExcecaoParaNomeDeContinenteInvalido(final String abreviaturaInvalida) {
    final IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getContinentePorNome(abreviaturaInvalida); });
    assertThat("Deve lan�ar exce��o de nome inv�lido.", excecao.getMessage(), equalTo(String.format("Nome informado (%s) � inv�lido.", abreviaturaInvalida)));
  }
  
  @Test
  public void deveLancarExcecaoParaAbreviaturaDeContinenteNula() {
    final String abreviaturaNula = null;
    IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getContinentePorAbreviatura(abreviaturaNula); });
    assertThat("Deve lan�ar exce��o de abreviatura inv�lida para pesquisa com abreviatura nula.", excecao.getMessage(), equalTo(String.format("Abreviatura informada (%s) � inv�lida.", abreviaturaNula)));
  }
  
  @Test
  public void deveLancarExcecaoParaNomeDeContinenteNulo() {
    final String nomeNulo = null;
    IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> { Continente.getContinentePorNome(nomeNulo); });
    assertThat("Deve lan�ar exce��o de nome inv�lido para pesquisa com nome nulo.", excecao.getMessage(), equalTo(String.format("Nome informado (%s) � inv�lido.", nomeNulo)));
  }
}