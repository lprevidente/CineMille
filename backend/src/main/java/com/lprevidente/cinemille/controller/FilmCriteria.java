package com.lprevidente.cinemille.controller;

import com.lprevidente.cinemille.utils.DateRange;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FilmCriteria {
  private String text;
  private DateRange range;

  public Optional<DateRange> getRange() {
    return Optional.ofNullable(range);
  }
}


