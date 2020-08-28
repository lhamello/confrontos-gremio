package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NotificacaoTamanhoExatoTest {

  private final NotificacaoTamanhoExato notificacao = NotificacaoTamanhoExato.criar();

  @Test
  void testMensagemSingular() {
    assertEquals("O campo Teste deve ter 1 caracter", notificacao.getMensagem("Teste", 1));
  }

  @Test
  void testMensagemPlural() {
    assertEquals("O campo Teste deve ter 5 caracteres", notificacao.getMensagem("Teste", 5));
  }

  @ParameterizedTest
  @ValueSource(ints = { -1, 0 })
  void testDeveLancarIllegalArgumentExceptionParaTamanhoMenorQue1(final int tamanho) {
    assertThrows(IllegalArgumentException.class, () -> notificacao.getMensagem("Teste", tamanho));
  }

  @Test
  void testToString() {
    assertEquals("Notificação de Tamanho Exato", notificacao.toString());
  }
}
