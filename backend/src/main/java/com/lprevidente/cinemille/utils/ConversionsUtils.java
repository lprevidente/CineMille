package com.lprevidente.cinemille.utils;

import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@UtilityClass
public class ConversionsUtils {

  public static String stringValue(Object o) {
    if (o == null) return null;
    if (o instanceof String s) return s;
    throw new ClassCastException(o.getClass().getName() + " can not be converted to String");
  }

  public static LocalDate localDateValue(Object o) {
    if (o == null) return null;
    if (o instanceof Date d) return d.toLocalDate();
    throw new ClassCastException(o.getClass().getName() + " can not be converted to LocalDate");
  }

  public static LocalTime localTimeValue(Object o) {
    if (o == null) return null;
    if (o instanceof Time t) return t.toLocalTime();
    throw new ClassCastException(o.getClass().getName() + " can not be converted to LocalDate");
  }

  public static int intValue(Object o) {
    if (o == null) return 0;
    else if (o instanceof Number n) return n.intValue();
    throw new ClassCastException(o.getClass().getName() + " can not be converted to int");
  }

  public static Long longValue(Object o) {
    if (o == null) return 0L;
    else if (o instanceof Number n) return n.longValue();
    throw new ClassCastException(o.getClass().getName() + " can not be converted to long");
  }

  public static boolean booleanValue(Object o) {
    if (o == null) return false;
    if (o instanceof Boolean b) return b;
    throw new ClassCastException(o.getClass().getName() + " can not be converted to boolean");
  }
}
