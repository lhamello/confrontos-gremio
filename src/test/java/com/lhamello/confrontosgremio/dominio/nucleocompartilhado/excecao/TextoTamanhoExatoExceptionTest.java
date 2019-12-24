package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TextoTamanhoExatoExceptionTest {

  private static final String NOME_CAMPO = "Teste";
  private static final int TAMANHO_EXATO = 1;

  @Test
  public void testConstrucaoObjeto() {
    assertDoesNotThrow(() -> new TextoTamanhoExatoException(NOME_CAMPO, TAMANHO_EXATO));
  }

  @Test
  public void testMensagemSingular() {
    assertEquals("Teste deve ter 1 caracter.", new TextoTamanhoExatoException(NOME_CAMPO, TAMANHO_EXATO).getMessage());
  }

  @Test
  public void testMensagemPlural() {
    assertEquals("Teste deve ter 2 caracteres.", new TextoTamanhoExatoException(NOME_CAMPO, 2).getMessage());
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, -1 })
  public void testTamanhoExataoInvalido(final int tamanhoExato) {
    assertThrows(IllegalArgumentException.class, () -> new TextoTamanhoExatoException(NOME_CAMPO, tamanhoExato));
  }
}
