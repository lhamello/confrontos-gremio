package br.com.lhamello.confrontosgremio.domain.shared.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class MessageProvider {

  private static final ResourceBundle RESOURCE_BUNDULE = ResourceBundle.getBundle("i18n/messages");

  private MessageProvider() {
    throw new AssertionError(getMessage("utilityClass.construction.message"));
  }

  public static String getMessage(final String key) {
    return RESOURCE_BUNDULE.getString(key);
  }

  public static String getMessage(final String key, final Object... params) {
    final String message = getMessage(key);
    return MessageFormat.format(message, params);
  }
}
