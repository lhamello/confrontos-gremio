package br.com.lhamello.confrontosgremio.domain.shared.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class MessageProviderTest {

  @Test
  void shouldHavePrivateConstructorMethod() throws NoSuchMethodException, SecurityException {
    final Constructor<MessageProvider> constructorMethod = MessageProvider.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(constructorMethod.getModifiers()));
  }

  @Test
  void shouldDoesNotCreateAInstanceOfMessageProvider() throws NoSuchMethodException, SecurityException {
    final Constructor<MessageProvider> constructorMethod = MessageProvider.class.getDeclaredConstructor();
    constructorMethod.setAccessible(true);
    final InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> constructorMethod.newInstance());
    assertAll(
        () -> assertEquals(AssertionError.class, exception.getCause().getClass()), 
        () -> assertEquals("O método construtor foi suprimido pois classe utilitária não deve ser instanciada.",exception.getCause().getMessage())
    );
  }

  @Test
  void shouldReturnMessage() {
    final String expected = "O método construtor foi suprimido pois classe utilitária não deve ser instanciada.";
    final String actual = MessageProvider.getMessage("utilityClass.validation.constraints.instanciation.message");
    assertEquals(expected, actual);
  }

  @Test
  void shouldReturnMessageWithParams() {
    final String expected1 = "Deve possuir 1 caracter.";
    final String actual1 = MessageProvider.getMessage("notification.validation.constraints.exactSize.message", 1);
    final String expected2 = "Deve possuir 30 caracteres.";
    final String actual2 = MessageProvider.getMessage("notification.validation.constraints.exactSize.message", 30);
    assertAll(
        () -> assertEquals(expected1, actual1), 
        () -> assertEquals(expected2, actual2)
    );
  }
}
