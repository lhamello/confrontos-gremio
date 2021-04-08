package br.com.lhamello.confrontosgremio.domain.shared.notification;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InvalidURLNotificationTest {

  @Test
  void shouldCreateInstanceSuccessfully() {
    final String expectedMessage = "URL inválida.";
    final InvalidURLNotification notification = InvalidURLNotification.create();
    
    assertAll(
        () -> assertEquals(expectedMessage, notification.toString()), 
        () -> assertEquals(expectedMessage, notification.getMessage())
    );
  }
}
