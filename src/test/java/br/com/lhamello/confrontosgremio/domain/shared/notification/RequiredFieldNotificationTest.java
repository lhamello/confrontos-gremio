package br.com.lhamello.confrontosgremio.domain.shared.notification;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RequiredFieldNotificationTest {

  @Test
  void shouldCreateInstanceSuccessfully() {
    final String expectedMessage = "Campo obrigatório.";
    assertDoesNotThrow(() -> RequiredFieldNotification.of());

    final RequiredFieldNotification notification = RequiredFieldNotification.of();
    assertAll(
        () -> assertEquals(expectedMessage, notification.toString()), 
        () -> assertEquals(expectedMessage, notification.getMessage())
    );
  }
  
  void test() {
    
  }
}
