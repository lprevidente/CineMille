package com.lprevidente.cinemille.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lprevidente.cinemille.utils.DateRange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DateRangeConverter implements Converter<String, DateRange> {

  private final ObjectMapper objectMapper;

  @Override
  public DateRange convert(@NonNull String source) {
    try {
      return objectMapper.readValue(source.getBytes(), DateRange.class);
    } catch (Exception exception) {
      log.warn(
          "Si è verificato un errore durante la conversione di una stringa in DateRange",
          exception);
      return null;
    }
  }
}
