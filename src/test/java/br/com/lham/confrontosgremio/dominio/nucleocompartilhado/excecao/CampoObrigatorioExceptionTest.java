package br.com.lham.confrontosgremio.dominio.nucleocompartilhado.excecao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.lham.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;

public class CampoObrigatorioExceptionTest {

  @Test
  public void deveCriarExcecao() {
    assertDoesNotThrow(() -> new CampoObrigatorioException("Nome"));
  }

  @Test
  public void deveRetornarMensagem() {
    assertEquals("Informe o campo Nome.", new CampoObrigatorioException("Nome").getMessage());
  }
}
