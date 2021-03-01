package br.com.lhamello.confrontosgremio.domain.shared.notification;

import br.com.lhamello.confrontosgremio.domain.shared.util.MessageProvider;

public final class ExceededMaximumSizeNotification extends AbstractNotification {

  private ExceededMaximumSizeNotification(final String message) {
    super(message);
  }

  public static ExceededMaximumSizeNotification of(int maxSize) {
    final String message = MessageProvider.getMessage("notification.maximumSize.message", maxSize);
    return new ExceededMaximumSizeNotification(message);
  }
}
