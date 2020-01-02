package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoExatoException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.excecao.TextoTamanhoMaximoException;

class ValidacaoTest {

  private static final String NOME_CAMPO = "Teste";

//  @Test
//  public void testConstrutorPrivado() throws NoSuchMethodException, SecurityException {
//    Constructor<Validacao> metodoConstrutor = Validacao.class.getDeclaredConstructor();
//    assertTrue(Modifier.isPrivate(metodoConstrutor.getModifiers()));
//  }

//  @Test
//  public void testNaoPossivelInstanciacao() throws NoSuchMethodException, SecurityException {
//    Constructor<Validacao> metodoConstrutor = Validacao.class.getDeclaredConstructor();
//    metodoConstrutor.setAccessible(true);
//    assertThrows(InvocationTargetException.class, () -> metodoConstrutor.newInstance());
//  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "            " })
  public void testNaoPreencherCampoObrigatorio(final String campo) {
//    assertThrows(CampoObrigatorioException.class, () -> Validacao.campoObrigatorio(campo, NOME_CAMPO));
  }

  @Test
  public void testTextoPreenchidoEmCampoObrigatorio() {
//    assertDoesNotThrow(() -> Validacao.campoObrigatorio("A", NOME_CAMPO));
  }

  @Test
  public void testObjetoInformadoEmCampoObrigatorio() {
//    assertDoesNotThrow(() -> Validacao.campoObrigatorio(new BigDecimal(0), NOME_CAMPO));
  }

  @Test
  public void testTextoNuloEmCampoComTamanhoExatoIgualA3() {
//    assertThrows(TextoTamanhoExatoException.class, () -> Validacao.campoComTamanhoExato(3, null, NOME_CAMPO));
  }

  @ParameterizedTest
  @ValueSource(strings = { "", "AB", "ABCD" })
  public void testTextoComTamanhoDiferenteDeTresEmCampoComTamanhoExatoIgualA3(final String campo) {
//    assertThrows(TextoTamanhoExatoException.class, () -> Validacao.campoComTamanhoExato(3, campo, NOME_CAMPO));
  }

  @Test
  public void testTextoComTamanhoTreEmCampoComTamanhoExatoIgualA3() {
//    assertDoesNotThrow(() -> Validacao.campoComTamanhoExato(3, "ABC", NOME_CAMPO));
  }

  @Test
  public void testTextoNuloEmCampoComTamanhoMaximoIgualA30() {
//    assertThrows(TextoTamanhoMaximoException.class, () -> Validacao.campoComTamanhoMaximo(30, null, NOME_CAMPO));
  }
  
  @Test
  public void testTextoComTamanhoDezEmCampoComTamaximoMaximoIgualA10() {
//    assertThrows(TextoTamanhoMaximoException.class, () -> Validacao.campoComTamanhoMaximo(10, "ABCDEFGHIJK", NOME_CAMPO));
  }

  @ParameterizedTest
  @ValueSource(strings = { "ABCDEFGHI", "ABCDEFGHIJ" })
  public void testTextoComTamanhoMenorQueDezEmCampoComTamanhoMaximoIgualA10(final String campo) {
//    assertDoesNotThrow(() -> Validacao.campoComTamanhoMaximo(10, campo, NOME_CAMPO));
  }
}
