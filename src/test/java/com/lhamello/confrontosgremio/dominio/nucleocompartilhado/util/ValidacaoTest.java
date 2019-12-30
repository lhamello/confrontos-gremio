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
  public void testMetodoConstrutorPrivado() throws NoSuchMethodException, SecurityException {
    Constructor<Validacao> metodoConstrutor = Validacao.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(metodoConstrutor.getModifiers()));
  }

  @Test
  public void testNaoPossivelInstanciacao() throws NoSuchMethodException, SecurityException {
    Constructor<Validacao> metodoConstrutor = Validacao.class.getDeclaredConstructor();
    metodoConstrutor.setAccessible(true);
    InvocationTargetException excecao = assertThrows(InvocationTargetException.class, () -> metodoConstrutor.newInstance());
    assertEquals(AssertionError.class, excecao.getCause().getClass());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "            " })
  public void testCampoObrigatorioNaoPreenchido(final String campo) {
    assertThrows(CampoObrigatorioException.class, () -> Validacao.campoObrigatorio(campo, "Teste"));
  }

  @Test
  public void testCampoObrigatorioPreenchido() {
    assertDoesNotThrow(() -> Validacao.campoObrigatorio("A", "Teste"));
  }
}
