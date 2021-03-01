package br.com.lhamello.confrontosgremio.domain.shared.notification;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MustContainOnlyLettersNotificationTest {

  @Test
  void shouldCreateInstanceSuccessfully() {
    final String expectedMessage = "Deve conter somente letras.";
    
    assertDoesNotThrow(() -> MustContainOnlyLettersNotification.of());
    
    final MustContainOnlyLettersNotification notification = MustContainOnlyLettersNotification.of();
    
    assertAll(
        () -> assertEquals(expectedMessage, notification.toString()),
        () -> assertEquals(expectedMessage, notification.getMessage())
    );
  }
}
