package com.lprevidente.cinemille.utils;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DateRange {
  @NotNull
  private LocalDate start;
  @NotNull
  private LocalDate end;
}