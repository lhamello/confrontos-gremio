package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.objetodevalor.tipo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.NotificacaoCampoObrigatorio;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.NotificacaoTamanhoExato;

class ValorStringTest {

  private ValorString instancia;

  @BeforeEach
  void criarInstanciaTeste() {
    instancia = ValorString.criar("Teste");
  }

  @Test
  void testCriarNovaInstancia() {
    assertEquals("Teste", instancia.getValor());
  }

  @Test
  void testNaoDeveRetornarNotificacaoCampoObrigatorio() {
    assertEquals(Optional.empty(), instancia.notificarSeNuloOuBranco());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  void testDeveRetornarNotificacaoCampoObrigatorio(final String valor) {
    final ValorString instancia = ValorString.criar(valor);
    assertThat(instancia.notificarSeNuloOuBranco()).containsInstanceOf(NotificacaoCampoObrigatorio.class);
  }

  @Test
  void testNaoDeveRetornarNotificacaoTamanhoExato() {
    assertEquals(Optional.empty(), instancia.notificarSeTamanhoDiferenteDe(5));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   ", "Test", "Teste1" })
  void testDeveRetornarNotificacaoTamanhoExato(final String valor) {
    final ValorString instancia = ValorString.criar(valor);
    assertThat(instancia.notificarSeTamanhoDiferenteDe(5)).containsInstanceOf(NotificacaoTamanhoExato.class);
  }
}
