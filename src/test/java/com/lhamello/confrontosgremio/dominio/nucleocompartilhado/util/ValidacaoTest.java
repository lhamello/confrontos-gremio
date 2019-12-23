package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;

class ValidacaoTest {

  @Test
  public void deveTerMetodoConstrutorPrivado() throws NoSuchMethodException, SecurityException {
    Constructor<Validacao> metodoConstrutor = Validacao.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(metodoConstrutor.getModifiers()));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void naoDeveSerPossivelInstanciar() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
    Class clazz = Class.forName(Validacao.class.getName());
    Constructor metodoConstrutor = clazz.getDeclaredConstructor();
    metodoConstrutor.setAccessible(true);
    InvocationTargetException excecao = assertThrows(InvocationTargetException.class, () -> metodoConstrutor.newInstance());
    assertEquals(AssertionError.class, excecao.getCause().getClass());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "            " })
  public void deveRetornarExcecaoAoValidar(final String texto) {
    final String nomeCampo = "Nome";
    final CampoObrigatorioException excecao = assertThrows(CampoObrigatorioException.class, () -> Validacao.campoObrigatorio(texto, nomeCampo));
//    assertEquals(nomeCampo, excecao.getNomeCampo());
  }

  @ParameterizedTest
  @ValueSource(strings = { "Teste", "Teste 2", "Teste com mais palavras" })
  public void naoDeveRetornarExcecaoAoValidar(final String texto) {
    assertDoesNotThrow(() -> Validacao.campoObrigatorio(texto, "Idade"));
  }
}
