package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class ProvedorMensagemTest {

  @Test
  void testConstrutorPrivado() throws NoSuchMethodException, SecurityException {
    final Constructor<ProvedorMensagem> metodoConstrutor = ProvedorMensagem.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(metodoConstrutor.getModifiers()));
  }

  @Test
  public void testNaoPossivelInstanciacao() throws NoSuchMethodException, SecurityException {
    final Constructor<ProvedorMensagem> metodoConstrutor = ProvedorMensagem.class.getDeclaredConstructor();
    metodoConstrutor.setAccessible(true);

    assertThrows(InvocationTargetException.class, () -> metodoConstrutor.newInstance());
  }

  @Test
  public void testGetMensagem() {
    assertEquals("O método construtor foi suprimido pois classe utilitária não deve ser instanciada", ProvedorMensagem.getMensagem("erro.instanciacao.classeUtilitaria"));
  }

  @Test
  public void testGetMensagemComParametros() {
    assertEquals("O campo Teste deve ter 1 caracter", ProvedorMensagem.getMensagem("erro.validacao.tamanhoExato", "Teste", 1, "caracter"));
    assertEquals("O campo Teste deve ter 30 caracteres", ProvedorMensagem.getMensagem("erro.validacao.tamanhoExato", "Teste", 30, "caracteres"));
  }
}
