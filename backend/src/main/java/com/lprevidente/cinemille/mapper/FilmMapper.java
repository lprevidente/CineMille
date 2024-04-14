package com.lprevidente.cinemille.mapper;

import com.lprevidente.cinemille.dto.FilmDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.lprevidente.cinemille.utils.ConversionsUtils.*;

@Component
public class FilmMapper {

  public Collection<FilmDto> toDto(List<Object[]> rows) {
    final var filmsMap = new HashMap<Long, FilmDto>();

    for (Object[] columns : rows) {
      final var filmId = (Long) columns[0];

      final var filmDto = filmsMap.computeIfAbsent(filmId, _ -> new FilmDto(
          filmId,
          stringValue(columns[1]),
          stringValue(columns[2]),
          localDateValue(columns[3]),
          intValue(columns[4])
      ));

      final var screeningDate = localDateValue(columns[5]);
      filmDto.addScreening(screeningDate, new FilmDto.ScreeningInfoDto(
          localTimeValue(columns[6]),
          new FilmDto.RoomDto(longValue(columns[7]), stringValue(columns[8]))
      ));
    }

    return filmsMap.values();
  }
}
