package com.lham.confrontosgremio.nucleo.excecao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;

public class CampoObrigatorioExceptionTest {

  @Test
  public void deveCriarExcecao() {
    assertDoesNotThrow(() -> new CampoObrigatorioException("Nome"));
  }

  @Test
  public void deveRetornarMensagem() {
    assertEquals("Informe o campo: Nome.", new CampoObrigatorioException("Nome").getMessage());
  }
}
