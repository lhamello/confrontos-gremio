package br.com.lhamello.confrontosgremio.domain.shared.notification;

import java.util.Objects;

public abstract class AbstractNotification {

  protected final String message;

  protected AbstractNotification(final String message) {
    this.message = Objects.requireNonNull(message, "Message is mandatory.");
  }

  protected String getMessage() {
    return message;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof AbstractNotification)) {
      return false;
    }

    final AbstractNotification other = (AbstractNotification) object;
    return Objects.equals(message, other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return message;
  }
}
