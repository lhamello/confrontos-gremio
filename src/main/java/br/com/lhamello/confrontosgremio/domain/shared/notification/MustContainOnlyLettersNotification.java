package br.com.lhamello.confrontosgremio.domain.shared.notification;

import br.com.lhamello.confrontosgremio.domain.shared.util.MessageProvider;

public class MustContainOnlyLettersNotification extends AbstractNotification {

  private MustContainOnlyLettersNotification(final String message) {
    super(message);
  }

  public static MustContainOnlyLettersNotification of() {
    final String message = MessageProvider.getMessage("notification.mustContainOnlyLetters.message");
    return new MustContainOnlyLettersNotification(message);
  }
}
