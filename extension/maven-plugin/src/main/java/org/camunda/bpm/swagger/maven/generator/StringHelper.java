package org.camunda.bpm.swagger.maven.generator;

import java.util.StringTokenizer;

public class StringHelper {

  public static String toFirstUpper(final String text) {
    if (text == null) {
      return null;
    }
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }

  public static String toFirstLower(final String text) {
    if (text == null) {
      return null;
    }
    return text.substring(0, 1).toLowerCase() + text.substring(1);
  }

  public static String camelize(final String value) {
    if (value == null || !value.contains("-")) {
      return value;
    }
    final StringTokenizer token = new StringTokenizer(value, "-");
    final StringBuilder str = new StringBuilder(token.nextToken());
    while (token.hasMoreTokens()) {
      final String s = token.nextToken();
      str.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
    }
    return str.toString();
  }

  public static String splitCamelCase(final String s) {
    return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
  }

}