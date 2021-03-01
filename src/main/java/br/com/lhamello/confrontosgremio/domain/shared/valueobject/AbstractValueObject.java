package br.com.lhamello.confrontosgremio.domain.shared.valueobject;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.domain.shared.notification.AbstractNotification;
import br.com.lhamello.confrontosgremio.domain.shared.type.Type;

public abstract class AbstractValueObject<T extends Type<?>> implements Serializable {

  private static final long serialVersionUID = 4663257514835786410L;
  private final List<AbstractNotification> notifications;
  protected final T value;

  protected AbstractValueObject(final T value) {
    this.value = value;
    this.notifications = new LinkedList<>();
  }

  protected void addNotificationsIfPresent(final List<Optional<AbstractNotification>> notifications) {
    notifications.forEach(notification -> {

      if (notification.isPresent()) {
        this.notifications.add(notification.get());
      }
    });
  }

  public List<AbstractNotification> getNotifications() {
    return notifications;
  }
}
