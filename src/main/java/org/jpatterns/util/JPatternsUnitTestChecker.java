package org.jpatterns.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JPatternsChecker {
  public boolean isTypeAnnotated(Class<? extends Annotation> annotation,
                                 Class<?> type) {
    return type.getAnnotation(annotation) != null;
  }

  public boolean isTypeAnnotated(Class<? extends Annotation> annotation,
                                 String typeName) {
    try {
      Class<?> type = Class.forName(typeName);
      return type.getAnnotation(annotation) != null;
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("Class " + typeName + " not found");
    }
  }

  public boolean isMethodAnnotated(Class<? extends Annotation> annotation,
                                   Class<?> type, String methodName,
                                   Class<?>... parameterTypes) {
    try {
      Method method = type.getDeclaredMethod(methodName, parameterTypes);
      return method.getAnnotation(annotation) != null;
    } catch (NoSuchMethodException e) {
      throw new IllegalStateException("No such method: " + type.getName() + "."
          + methodName + "(" + Arrays.toString(parameterTypes) + ")");
    }
  }
}