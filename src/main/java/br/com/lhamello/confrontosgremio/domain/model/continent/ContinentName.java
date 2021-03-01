package br.com.lhamello.confrontosgremio.domain.model.continent;

import java.util.List;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.domain.shared.notification.AbstractNotification;
import br.com.lhamello.confrontosgremio.domain.shared.type.Text;
import br.com.lhamello.confrontosgremio.domain.shared.valueobject.AbstractValueObject;

public class ContinentName extends AbstractValueObject<Text> {

  private static final long serialVersionUID = 5733508008815022659L;
  private static final int MAX_SIZE = 16;

  protected ContinentName(final Text value) {
    super(value);
    this.validate();
  }

  public static ContinentName of(final String value) {
    final Text typeValue = Text.of(value);
    return new ContinentName(typeValue);
  }

  private void validate() {
    final List<Optional<AbstractNotification>> notifications = List.of(
        super.value.notifyIfBlank(), 
        super.value.notifyIfExceededMaxSize(MAX_SIZE),
        super.value.notifyIfDoesNotContainsOnlyLetters());

    super.addNotificationsIfPresent(notifications);
  }

  @Override
  public String toString() {
    return super.value.getValue();
  }
}
