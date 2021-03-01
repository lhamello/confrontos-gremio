package br.com.lhamello.confrontosgremio.domain.shared.notification;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExceededMaximumSizeNotificationTest {

  @Test
  void shouldCreateInstanceSuccessfully() {
    final int maxSize = 150;
    final String expectedMessage = "Deve possuir no máximo 150 caracteres.";
    
    assertDoesNotThrow(() -> ExceededMaximumSizeNotification.of(maxSize));
    
    final ExceededMaximumSizeNotification notification = ExceededMaximumSizeNotification.of(maxSize);
    
    assertAll(
        () -> assertEquals(expectedMessage, notification.toString()),
        () -> assertEquals(expectedMessage, notification.getMessage())
    );
  }
}
