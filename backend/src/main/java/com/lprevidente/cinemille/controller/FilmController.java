package com.lprevidente.cinemille.controller;

import com.lprevidente.cinemille.dto.FilmDto;
import com.lprevidente.cinemille.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/films")
public class FilmController {
  private final FilmService filmService;

  @GetMapping(params = "on_shown=true")
  public Collection<FilmDto> getFilmsOnShown() {
    return filmService.findAllOnShown();
  }

  @GetMapping(params = "on_shown=false")
  public Collection<FilmDto> getHistory(FilmCriteria criteria) {
    return filmService.findHistory(criteria);
  }
}
