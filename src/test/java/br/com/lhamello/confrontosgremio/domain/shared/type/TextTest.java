package br.com.lhamello.confrontosgremio.domain.shared.type;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lhamello.confrontosgremio.domain.shared.a.RequiredFieldNotification;
import br.com.lhamello.confrontosgremio.domain.shared.notification.ExceededMaximumSizeNotification;
import br.com.lhamello.confrontosgremio.domain.shared.notification.MustContainOnlyLettersNotification;

class TextTest {

  @Test
  void shouldCreateInstanceSuccessfully() {
    final String value = "Texto teste!";
    assertDoesNotThrow(() -> Text.of(value));
    
    final Text text = Text.of(value);
    assertAll(
        () -> assertEquals(value, text.toString()), 
        () -> assertEquals(value, text.getValue())
    );
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "    " })
  void shouldReturnRequiredFieldNotification(final String value) {
    final Text text = Text.of(value);
    final Optional<RequiredFieldNotification> expectedNotification = Optional.of(RequiredFieldNotification.of());
    assertAll(
        () -> assertTrue(text.notifyIfBlank().isPresent()), 
        () -> assertEquals(expectedNotification.get(), text.notifyIfBlank().get())
    );
  }
  
  @Test
  void shouldNotReturnRequiredFieldNotification() {
    final Text text = Text.of("Texto teste!");
    assertTrue(text.notifyIfBlank().isEmpty());
  }
  
  @ParameterizedTest
  @ValueSource(strings = { "123", "abx%", "$#¨¨", "..!" })
  void shouldReturnMustContainOnlyLettersNotification(final String value) {
    final Text text = Text.of(value);
    final Optional<MustContainOnlyLettersNotification> expectedNotification = Optional.of(MustContainOnlyLettersNotification.of());
    assertAll(
        () -> assertTrue(text.notifyIfDoesNotContainsOnlyLetters().isPresent()), 
        () -> assertEquals(expectedNotification.get(), text.notifyIfDoesNotContainsOnlyLetters().get())
    );
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "    ", "Teste", "Teste Composto" })
  void shouldNotReturnMustContainOnlyLettersNotification(final String value) {
    final Text text = Text.of(value);
    assertTrue(text.notifyIfDoesNotContainsOnlyLetters().isEmpty());
  }
  
  @Test
  void shouldReturnExceededMaximumSizeNotification() {
    final int maxSize = 10;
    final Text text = Text.of("abcdefghijl");
    final Optional<ExceededMaximumSizeNotification> expectedNotification = Optional.of(ExceededMaximumSizeNotification.of(maxSize));
    assertAll(
        () -> assertTrue(text.notifyIfExceededMaxSize(maxSize).isPresent()), 
        () -> assertEquals(expectedNotification.get(), text.notifyIfExceededMaxSize(maxSize).get())
    ); 
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "    ", "123456789", "1234567890", "foo bar" })
  void shouldNotReturnExceededMaximumSizeNotification(final String value) {
    final int maxSize = 10;
    final Text text = Text.of(value);
    assertTrue(text.notifyIfExceededMaxSize(maxSize).isEmpty());
  }
  
  //HASHCODE
  
  @Test
  void shouldReturnSameHashcode() {
    final Text text1 = Text.of("Teste");
    final Text text2 = Text.of("Teste");
    assertEquals(text1.hashCode(), text2.hashCode());
  }
  
  @Test
  void shouldReturnNotSameHashcode() {
    final Text text1 = Text.of("Teste1");
    final Text text2 = Text.of("Teste2");
    assertNotEquals(text1.hashCode(), text2.hashCode());
  }
  
  // EQUALS
  
  @Test
  void shouldBeEquals() {
    final Text text1 = Text.of("Teste");
    final Text text2 = Text.of("Teste");
    assertAll(
        () -> assertEquals(text1, text1),
        () -> assertEquals(text2, text2),
        () -> assertEquals(text1, text2)
    );
  }
  
  @Test
  void shouldBeNotEquals() {
    final Text text1 = Text.of("Teste1");
    final Text text2 = Text.of("Teste2");
    final RequiredFieldNotification notification = RequiredFieldNotification.of();
    assertAll(
        () -> assertNotEquals(text1, text2),
        () -> assertNotEquals(text1, notification),
        () -> assertNotEquals(text2, notification),
        () -> assertNotEquals(text2, null)
    );
  }
}
