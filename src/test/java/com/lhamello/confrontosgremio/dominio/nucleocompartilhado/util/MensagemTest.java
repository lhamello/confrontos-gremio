package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class MensagemTest {

  @Test
  public void testConstrutorPrivado() throws NoSuchMethodException, SecurityException {
    Constructor<Mensagem> metodoConstrutor = Mensagem.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(metodoConstrutor.getModifiers()));
  }

  @Test
  public void testNaoPossivelInstanciacao() throws NoSuchMethodException, SecurityException {
    Constructor<Mensagem> metodoConstrutor = Mensagem.class.getDeclaredConstructor();
    metodoConstrutor.setAccessible(true);
    assertThrows(InvocationTargetException.class, () -> metodoConstrutor.newInstance());
  }

  @Test
  public void testGetMensagem() {
    assertEquals("Construtor foi suprimido pois classe utilitária não deve ser instanciada.", Mensagem.getMensagem("global.erro.instanciar.classeutilitaria"));
  }

  @Test
  public void testGetMensagemComParametros() {
    assertEquals("Campo Teste deve ter 30 caracteres.", Mensagem.getMensagem("dominio.nucleocompartilhado.excecao.textotamanhoexato.plural", "Teste", 30));
  }
}
