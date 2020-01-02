package com.lhamello.confrontosgremio.dominio.model.pais;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoExatoException;

public class PaisTest {

  private static final String ABREVIATURA = "BRA";
  private static final String NOME = "BRASIL";
  private static final Continente CONTINENTE = Continente.AMERICA_DO_SUL;

  @Test
  public void testCriarNovoPaisComSucesso() {
    Pais pais = new Pais(ABREVIATURA, NOME, CONTINENTE);
    assertTrue(pais.getErrosValidacao().isEmpty());
  }

//  @ParameterizedTest
//  @NullAndEmptySource
//  @ValueSource(strings = { " ", "  ", "   " })
//  public void testNovoPaisSemAbreviatura(final String abreviatura) {
//    Pais pais = new Pais(abreviatura, NOME, CONTINENTE);
//    assertAll(
//        () -> assertEquals(2, pais.getErrosValidacao().size()),
//        () -> assertEquals(new CampoObrigatorioException("Abreviatura").getMessage(), pais.getErrosValidacao().get(0).getMessage()),
//        () -> assertEquals(new TextoTamanhoExatoException("Abreviatura", 3).getMessage(), pais.getErrosValidacao().get(1).getMessage()));
//  }

//  @ParameterizedTest
//  @ValueSource(strings = { "A", "AB", "ABCD" })
//  public void testNovoPaisComTamanhoAbreviaturaDiferenteDe3(final String abreviatura) {
//    assertThrows(TextoTamanhoExatoException.class, () -> new Pais(abreviatura, NOME, CONTINENTE));
//  }
//
//  @Test
//  public void testGetAbreviatura() {
//    final Pais pais = new Pais(ABREVIATURA, NOME, CONTINENTE);
//    assertEquals(ABREVIATURA, pais.getAbreviatura());
//  }
//
//  @ParameterizedTest
//  @NullAndEmptySource
//  @ValueSource(strings = { " ", "  ", "   " })
//  public void testNovoPaisSemNome(final String nome) {
//    assertThrows(CampoObrigatorioException.class, () -> new Pais(ABREVIATURA, nome, CONTINENTE));
//  }
//
//  @Test
//  public void testNovoPaisComNomeComMaisDeCinquentaCaracteres() {
//    assertThrows(TextoTamanhoMaximoException.class, () -> new Pais("RAS", "TESTEDENOMEDEPAISCOMMAISDECINQUENTACARACTERESSSSS51", Continente.AFRICA));
//  }
//
//  @Test
//  public void testGetNome() {
//    final Pais pais = new Pais(ABREVIATURA, NOME, CONTINENTE);
//    assertEquals(NOME, pais.getNome());
//  }
//
//  @Test
//  public void testNovoPaisSemContinente() {
//    assertThrows(CampoObrigatorioException.class, () -> new Pais(ABREVIATURA, NOME, null));
//  }
//
//  @Test
//  public void testGetContinente() {
//    final Pais pais = new Pais(ABREVIATURA, NOME, CONTINENTE);
//    assertEquals(CONTINENTE, pais.getContinente());
//  }
//
//  @Test
//  public void testToString() {
//    final Pais pais = new Pais(ABREVIATURA, NOME, CONTINENTE);
//    final String esperado = String.format("%s (%s)", NOME, ABREVIATURA);
//    assertEquals(esperado, pais.toString());
//  }
}
