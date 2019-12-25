package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;

public class CampoObrigatorioExceptionTest {

  private static final String NOME_CAMPO = "Teste";

  @Test
  public void testInstanciacao() {
    assertDoesNotThrow(() -> new CampoObrigatorioException(NOME_CAMPO));
  }

  @Test
  public void testMensagem() {
    assertEquals("Informe o campo Teste.", new CampoObrigatorioException(NOME_CAMPO).getMessage());
  }
}
