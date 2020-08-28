package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.NotificacaoCampoObrigatorio;

class NotificacaoCampoObrigatorioTest {

  @Test
  void testMensagem() {
    final NotificacaoCampoObrigatorio notificacao = NotificacaoCampoObrigatorio.criar();
    assertEquals("O campo Teste é de preenchimento obrigatório", notificacao.getMensagem("Teste"));
  }

  @Test
  void testToString() {
    assertEquals("Notificação de Campo Obrigatório", NotificacaoCampoObrigatorio.criar().toString());
  }
}
