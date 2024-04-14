package com.lprevidente.cinemille.service;

import com.lprevidente.cinemille.controller.FilmCriteria;
import com.lprevidente.cinemille.dto.FilmDto;
import com.lprevidente.cinemille.mapper.FilmMapper;
import com.lprevidente.cinemille.repository.FilmRepository;
import com.lprevidente.cinemille.utils.DateRange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmRepository filmRepository;
  private final FilmMapper filmMapper;

  public Collection<FilmDto> findAllOnShown() {
    return filmMapper.toDto(filmRepository.findAllOnShown());
  }

  public Collection<FilmDto> findHistory(FilmCriteria criteria) {
    return filmMapper.toDto(filmRepository.findHistory(
        criteria.getText(),
        criteria.getRange().map(DateRange::getStart).orElse(null),
        criteria.getRange().map(DateRange::getEnd).orElse(null)));
  }
}
