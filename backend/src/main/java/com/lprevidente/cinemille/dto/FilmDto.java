package com.lprevidente.cinemille.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record FilmDto(
    Long id,
    String title,
    String description,
    LocalDate releaseDate,
    int durationInMinutes,
    Map<LocalDate, List<ScreeningInfoDto>> screenings) {

  public FilmDto(Long id, String title, String description, LocalDate releaseDate, int durationInMinutes) {
    this(id, title, description, releaseDate, durationInMinutes, new HashMap<>());
  }

  public void addScreening(LocalDate date, ScreeningInfoDto screeningInfo) {
    screenings.computeIfAbsent(date, _ -> new ArrayList<>()).add(screeningInfo);
  }

  public record ScreeningInfoDto(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") LocalTime startTime,
                                 RoomDto room) {
  }

  public record RoomDto(Long id, @NotNull String name) {
  }
}
