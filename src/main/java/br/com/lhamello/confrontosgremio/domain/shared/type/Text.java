package br.com.lhamello.confrontosgremio.domain.shared.type;

import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Objects;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.domain.shared.notification.AbstractNotification;
import br.com.lhamello.confrontosgremio.domain.shared.notification.ExceededMaximumSizeNotification;
import br.com.lhamello.confrontosgremio.domain.shared.notification.MustContainOnlyLettersNotification;
import br.com.lhamello.confrontosgremio.domain.shared.notification.RequiredFieldNotification;

public final class Text implements Type<String> {

  private final String value;

  private Text(final String value) {
    this.value = value;
  }

  public static Text of(final String value) {
    return new Text(value);
  }

  @Override
  public String getValue() {
    return value;
  }

  public Optional<AbstractNotification> notifyIfBlank() {
    return isBlank(value) ? Optional.of(RequiredFieldNotification.of()) : Optional.empty();
  }

  public Optional<AbstractNotification> notifyIfDoesNotContainsOnlyLetters() {
    return (isNotBlank(value) && !isAlpha(deleteWhitespace(value))) ? Optional.of(MustContainOnlyLettersNotification.of()) : Optional.empty();
  }

  public Optional<AbstractNotification> notifyIfExceededMaxSize(final int maxSize) {
    return (isNotBlank(value) && value.length() > maxSize) ? Optional.of(ExceededMaximumSizeNotification.of(maxSize)) : Optional.empty();
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof Text)) {
      return false;
    }

    final Text other = (Text) object;
    return Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
  
  @Override
  public String toString() {
    return value;
  }
}
