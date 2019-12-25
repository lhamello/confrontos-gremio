package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TextoTamanhoMaximoExceptionTest {


  private static final String NOME_CAMPO = "Teste";
  private static final int TAMANHO_MAXIMO = 1;

  @Test
  public void testInstanciacao() {
    assertDoesNotThrow(() -> new TextoTamanhoMaximoException(NOME_CAMPO, TAMANHO_MAXIMO));
  }

  @Test
  public void testMensagemSingular() {
    assertEquals("Campo Teste deve ter no máximo 1 caracter.", new TextoTamanhoMaximoException(NOME_CAMPO, TAMANHO_MAXIMO).getMessage());
  }

  @Test
  public void testMensagemPlural() {
    assertEquals("Campo Teste deve ter no máximo 2 caracteres.", new TextoTamanhoMaximoException(NOME_CAMPO, 2).getMessage());
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, -1 })
  public void testTamanhoMaximoInvalido(final int tamanhoMaximo) {
    assertThrows(IllegalArgumentException.class, () -> new TextoTamanhoMaximoException(NOME_CAMPO, tamanhoMaximo));
  }
}
