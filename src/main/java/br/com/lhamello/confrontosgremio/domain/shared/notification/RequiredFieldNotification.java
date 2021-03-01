package br.com.lhamello.confrontosgremio.domain.shared.notification;

import br.com.lhamello.confrontosgremio.domain.shared.util.MessageProvider;

public final class RequiredFieldNotification extends AbstractNotification {

  private RequiredFieldNotification(final String message) {
    super(message);
  }

  public static RequiredFieldNotification of() {
    final String message = MessageProvider.getMessage("notification.requiredField.message");
    return new RequiredFieldNotification(message);
  }
}
